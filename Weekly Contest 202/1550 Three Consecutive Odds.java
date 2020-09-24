/**
Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 

Example 1:

Input: arr = [2,6,4,1]
Output: false
Explanation: There are no three consecutive odds.
Example 2:

Input: arr = [1,2,34,3,4,5,7,23,12]
Output: true
Explanation: [5,7,23] are three consecutive odds.
 */

 class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;
        //if (arr.length == 2) return (arr[0] % 2 == 1) && arr[1] % 2 == 1;
        for (int i = 0; i <= arr.length - 3; i++){
            if (arr[i] % 2 == 1 && arr[i+1] % 2 == 1 && arr[i+2] % 2 == 1) return true;
        }
        return false;
    }
}