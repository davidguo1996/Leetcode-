/**
Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts where horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.

Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a huge number, return this modulo 10^9 + 7.

 

Example 1:



Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4 
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.
Example 2:



Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
Output: 6
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and yellow pieces of cake have the maximum area.
Example 3:

Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
Output: 9
 */

 class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxh = horizontalCuts[0];
        int maxv = verticalCuts[0];
        for (int i = 0; i < horizontalCuts.length; i++){
            if (i == horizontalCuts.length - 1){
                maxh = Math.max(maxh, h - horizontalCuts[i]);
                continue;
            }
            maxh = Math.max(maxh, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        for (int i = 0; i < verticalCuts.length; i++){
            if (i == verticalCuts.length - 1){
                maxv = Math.max(maxv, w - verticalCuts[i]);
                continue;
            }
            maxv = Math.max(maxv, verticalCuts[i + 1] - verticalCuts[i]);
        }
        return (int)(((long)maxv * (long)maxh) % 1000000007) ;
    }
}