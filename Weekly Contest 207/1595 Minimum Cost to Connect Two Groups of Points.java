/**
You are given two groups of points where the first group has size1 points, the second group has size2 points, and size1 >= size2.

The cost of the connection between any two points are given in an size1 x size2 matrix where cost[i][j] is the cost of connecting point i of the first group and point j of the second group. The groups are connected if each point in both groups is connected to one or more points in the opposite group. In other words, each point in the first group must be connected to at least one point in the second group, and each point in the second group must be connected to at least one point in the first group.

Return the minimum cost it takes to connect the two groups.

 

Example 1:


Input: cost = [[15, 96], [36, 2]]
Output: 17
Explanation: The optimal way of connecting the groups is:
1--A
2--B
This results in a total cost of 17.
Example 2:


Input: cost = [[1, 3, 5], [4, 1, 1], [1, 5, 3]]
Output: 4
Explanation: The optimal way of connecting the groups is:
1--A
2--B
2--C
3--A
This results in a total cost of 4.
Note that there are multiple points connected to point 2 in the first group and point A in the second group. This does not matter as there is no limit to the number of points that can be connected. We only care about the minimum total cost.
Example 3:

Input: cost = [[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]
Output: 10
 */

 class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int size1 = cost.size(), size2 = cost.get(0).size();
        // dp[i][state] = min dp[i-1][state - subset] + cost of subset of current state
        // dp[i][state] = min cost of one node in state + dp[i - 1][state]
        int[][] dp = new int[size1][1<<size2];
        dp[0][0] = Integer.MAX_VALUE/2;
        for (int state = 1; state < 1<<size2; state++){
            
            int sum = 0;
            for (int j = 0; j < size2; j++){
                if (((state >> j)&1) == 1) sum += cost.get(0).get(j);
            }
            dp[0][state] = sum;
        }
        for (int i = 1; i < size1; i++){
            dp[i][0] = Integer.MAX_VALUE/2;
            for (int state = 1; state < (1<<size2); state++){
                dp[i][state] = Integer.MAX_VALUE;
                for (int subset = state; subset > 0; subset = (subset-1)&state){
                    int sum = 0;
                    for (int j = 0; j < size2; j++){
                        if (((subset >> j)&1) == 1) sum += cost.get(i).get(j);
                    }
                    dp[i][state] = Math.min(dp[i][state], dp[i-1][state - subset] + sum);
                }
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < size2; j++){
                    if (((state >> j)&1) == 1) min = Math.min(min, cost.get(i).get(j));
                    //min = Math.min(min, cost.get(i).get(j));
                }
                dp[i][state] = Math.min(dp[i][state], dp[i-1][state] + min);
            }
        }
        return dp[size1-1][(1<<size2) - 1];
    }
}