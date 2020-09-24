/**
You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colours: Red, Yellow or Green while making sure that no two adjacent cells have the same colour (i.e no two cells that share vertical or horizontal sides have the same colour).

You are given n the number of rows of the grid.

Return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 10^9 + 7.

 

Example 1:

Input: n = 1
Output: 12
Explanation: There are 12 possible way to paint the grid as shown:

Example 2:

Input: n = 2
Output: 54
Example 3:

Input: n = 3
Output: 246
Example 4:

Input: n = 7
Output: 106494
Example 5:

Input: n = 5000
Output: 30228214
 */

 class Solution {
    public int numOfWays(int n) {
        long two = 6;
        long three = 6;
        for (int i = 1; i < n; i++){
            long prv_two = two;
            two = (2 * three + 3 * two) % 1000000007;
            three = (2 * prv_two + 2 * three) % 1000000007;
        }
        long res = (two + three) % 1000000007;
        return (int)res;
    }
}