/**
Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).

The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.

 

Example 1:

Input: s = "011101"
Output: 5 
Explanation: 
All possible ways of splitting s into two non-empty substrings are:
left = "0" and right = "11101", score = 1 + 4 = 5 
left = "01" and right = "1101", score = 1 + 3 = 4 
left = "011" and right = "101", score = 1 + 2 = 3 
left = "0111" and right = "01", score = 1 + 1 = 2 
left = "01110" and right = "1", score = 2 + 1 = 3
Example 2:

Input: s = "00111"
Output: 5
Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
Example 3:

Input: s = "1111"
Output: 3
 */

 class Solution {
    public int maxScore(String s) {
        int[] zeros = new int[s.length()];
        int[] ones = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++){
            if (i == 0){
                zeros[i] = s.charAt(i) == '0' ? 1 : 0; 
                continue;
            }
            if (i == s.length() - 1){
                zeros[i] = zeros[i - 1];
                continue;
            }
            if (s.charAt(i) == '0'){
                zeros[i] = zeros[i - 1] + 1;
            } else {
                zeros[i] = zeros[i - 1];
            }
            
        }
        for (int i = s.length() - 1; i >= 0; i--){
            if (i == s.length() - 1){
                ones[i] = s.charAt(i) == '1' ? 1 : 0; 
                continue;
            }
            if (i == 0){
                ones[i] = ones[i + 1];
                continue;
            }
            if (s.charAt(i) == '1'){
                ones[i] = ones[i + 1] + 1;
            } else {
                ones[i] = ones[i + 1];
            }
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            res = Math.max(res, ones[i] + zeros[i]);
        }
        return res;
    }
}