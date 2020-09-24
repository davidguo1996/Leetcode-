/**
Given a rows x cols matrix mat, where mat[i][j] is either 0 or 1, return the number of special positions in mat.

A position (i,j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).

 

Example 1:

Input: mat = [[1,0,0],
              [0,0,1],
              [1,0,0]]
Output: 1
Explanation: (1,2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
Example 2:

Input: mat = [[1,0,0],
              [0,1,0],
              [0,0,1]]
Output: 3
Explanation: (0,0), (1,1) and (2,2) are special positions. 
Example 3:

Input: mat = [[0,0,0,1],
              [1,0,0,0],
              [0,1,1,0],
              [0,0,0,0]]
Output: 2
Example 4:

Input: mat = [[0,0,0,0,0],
              [1,0,0,0,0],
              [0,1,0,0,0],
              [0,0,1,0,0],
              [0,0,0,1,1]]
Output: 3
 */

 class Solution {
    public int numSpecial(int[][] mat) {
        int R = mat.length, C = mat[0].length;
        int[][] prefixRow = new int[R][C], prefixCol = new int[R][C];
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (i == 0) {
                    prefixRow[i][j] = mat[i][j];
                } else prefixRow[i][j] = prefixRow[i - 1][j] + mat[i][j];
                if (j == 0) prefixCol[i][j] = mat[i][j];
                else prefixCol[i][j] = prefixCol[i][j - 1] + mat[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (mat[i][j] == 1){
                    if (prefixRow[R - 1][j] == 1 && prefixCol[i][C - 1] == 1) res++;
                }
            }
        }
        return res;
    }
}