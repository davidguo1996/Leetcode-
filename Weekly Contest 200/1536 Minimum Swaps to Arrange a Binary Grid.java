/**
Given an n x n binary grid, in one step you can choose two adjacent rows of the grid and swap them.

A grid is said to be valid if all the cells above the main diagonal are zeros.

Return the minimum number of steps needed to make the grid valid, or -1 if the grid cannot be valid.

The main diagonal of a grid is the diagonal that starts at cell (1, 1) and ends at cell (n, n).

 

Example 1:


Input: grid = [[0,0,1],[1,1,0],[1,0,0]]
Output: 3
Example 2:


Input: grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
Output: -1
Explanation: All rows are similar, swaps have no effect on the grid.
Example 3:


Input: grid = [[1,0,0],[1,1,0],[1,1,1]]
Output: 0
 */

 class Solution {
    int res = 0;
    public int minSwaps(int[][] grid) {
        for (int r = 0; r < grid.length; r++){
            if (!valid(r, grid, r+1)){
                int targetR = find(r, grid);
                if (targetR == -1) return -1;
                swap(r, targetR, grid);
            }
        }
        return res;
    }
    private boolean valid(int r, int[][] grid, int start){
        for (int i = start; i < grid[0].length; i++){
            if (grid[r][i] != 0) return false;
        }
        return true;
    }
    private int find(int r, int[][] grid){
        for (int i = r + 1; i < grid.length; i++){
            if (valid(i, grid, r+1)) return i;
        }
        return -1;
    }
    private void swap(int r, int newR, int[][] grid){
        while (newR != r){
            swapRow(newR, newR-1, grid);
            res++;
            newR--;
        }
        return;
    }
    private void swapRow(int one, int two, int[][] grid){
        for (int i = 0; i < grid[0].length; i++){
            int temp = grid[one][i];
            grid[one][i] = grid[two][i];
            grid[two][i] = temp;
        }
        return;
    }
}