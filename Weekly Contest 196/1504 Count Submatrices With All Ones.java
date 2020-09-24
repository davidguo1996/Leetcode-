/**
Given a rows * columns matrix mat of ones and zeros, return how many submatrices have all ones.

 

Example 1:

Input: mat = [[1,0,1],
              [1,1,0],
              [1,1,0]]
Output: 13
Explanation:
There are 6 rectangles of side 1x1.
There are 2 rectangles of side 1x2.
There are 3 rectangles of side 2x1.
There is 1 rectangle of side 2x2. 
There is 1 rectangle of side 3x1.
Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
Example 2:

Input: mat = [[0,1,1,0],
              [0,1,1,1],
              [1,1,1,0]]
Output: 24
Explanation:
There are 8 rectangles of side 1x1.
There are 5 rectangles of side 1x2.
There are 2 rectangles of side 1x3. 
There are 4 rectangles of side 2x1.
There are 2 rectangles of side 2x2. 
There are 2 rectangles of side 3x1. 
There is 1 rectangle of side 3x2. 
Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
Example 3:

Input: mat = [[1,1,1,1,1,1]]
Output: 21
Example 4:

Input: mat = [[1,0,1],[0,1,0],[1,0,1]]
Output: 5
 */

 class Solution {
    public int numSubmat(int[][] mat) {
        int[][] prefix = calPrefix(mat);
        int res = 0;
        for (int j = 0; j < mat[0].length; j++){
            int i = mat.length - 1;
            Deque<int[]> stack = new ArrayDeque<>();
            int curSum = 0;
            while (i >= 0){
                int cur = 0;
                while (!stack.isEmpty() && stack.peekFirst()[0] > prefix[i][j]){
                    curSum -= (stack.peekFirst()[1] + 1) * (stack.peekFirst()[0] - prefix[i][j]);
                    cur += stack.peekFirst()[1] + 1;
                    stack.pollFirst();
                }
                curSum += prefix[i][j];
                res += curSum;
                stack.offerFirst(new int[]{prefix[i][j], cur});
                i--;
            }
        }
        return res;
    }
    private int[][] calPrefix(int[][] mat){
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++){
            for (int j = mat[0].length - 1; j >= 0; j--){
                if (mat[i][j] == 0) continue;
                if (j != mat[0].length - 1) res[i][j] = res[i][j+1];
                res[i][j] += 1;
            }
        }
        return res;
    }
}