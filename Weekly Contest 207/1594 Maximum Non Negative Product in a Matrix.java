/**
You are given a rows x cols matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.

Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (rows - 1, cols - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.

Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative return -1.

Notice that the modulo is performed after getting the maximum product.

 

Example 1:

Input: grid = [[-1,-2,-3],
               [-2,-3,-3],
               [-3,-3,-2]]
Output: -1
Explanation: It's not possible to get non-negative product in the path from (0, 0) to (2, 2), so return -1.
Example 2:

Input: grid = [[1,-2,1],
               [1,-2,1],
               [3,-4,1]]
Output: 8
Explanation: Maximum non-negative product is in bold (1 * 1 * -2 * -4 * 1 = 8).
Example 3:

Input: grid = [[1, 3],
               [0,-4]]
Output: 0
Explanation: Maximum non-negative product is in bold (1 * 0 * -4 = 0).
Example 4:

Input: grid = [[ 1, 4,4,0],
               [-2, 0,0,1],
               [ 1,-1,1,1]]
Output: 2
Explanation: Maximum non-negative product is in bold (1 * -2 * 1 * -1 * 1 * 1 = 2).
 */

 class Solution {
    public int maxProductPath(int[][] grid) {
        long[][] min = new long[grid.length][grid[0].length];
        long[][] max = new long[grid.length][grid[0].length];
        int MOD = 1000000007;
        
        for (int r = grid.length - 1; r >= 0; r--){
            for (int c = grid[0].length - 1; c >= 0; c--){
                long cur = (long)grid[r][c];
                
                if (r + 1 < grid.length && c + 1 < grid[0].length){
                    
                    min[r][c] = Math.min(cur * min[r+1][c] , cur * max[r + 1][c]);
                    min[r][c] = Math.min(min[r][c], cur * min[r][c+1]);
                    min[r][c] = Math.min(min[r][c], cur * max[r][c+1]);
                    
                    max[r][c] = Math.max(cur * min[r+1][c], cur * max[r + 1][c]);
                    max[r][c] = Math.max(max[r][c], cur * min[r][c+1]);
                    max[r][c] = Math.max(max[r][c], cur * max[r][c+1]);
                } else if (r + 1 < grid.length) {
                    min[r][c] = Math.min(cur * min[r+1][c], cur * max[r + 1][c]);
                    max[r][c] = Math.max(cur * min[r+1][c], cur * max[r + 1][c]);
                } else if (c + 1 < grid[0].length){
                    min[r][c] = Math.min(cur * min[r][c+1], cur * max[r][c+1]);
                    max[r][c] = Math.max(cur * min[r][c+1], cur * max[r][c+1]);
                } else {
                    min[r][c] = cur;
                    max[r][c] = cur;
                }
            }
        }
        return max[0][0] >= 0 ? (int)(max[0][0] % MOD) : -1;
    }
}