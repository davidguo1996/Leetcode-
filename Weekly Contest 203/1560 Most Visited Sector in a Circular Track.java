/**
Given an integer n and an integer array rounds. We have a circular track which consists of n sectors labeled from 1 to n. A marathon will be held on this track, the marathon consists of m rounds. The ith round starts at sector rounds[i - 1] and ends at sector rounds[i]. For example, round 1 starts at sector rounds[0] and ends at sector rounds[1]

Return an array of the most visited sectors sorted in ascending order.

Notice that you circulate the track in ascending order of sector numbers in the counter-clockwise direction (See the first example).

 

Example 1:


Input: n = 4, rounds = [1,3,1,2]
Output: [1,2]
Explanation: The marathon starts at sector 1. The order of the visited sectors is as follows:
1 --> 2 --> 3 (end of round 1) --> 4 --> 1 (end of round 2) --> 2 (end of round 3 and the marathon)
We can see that both sectors 1 and 2 are visited twice and they are the most visited sectors. Sectors 3 and 4 are visited only once.
Example 2:

Input: n = 2, rounds = [2,1,2,1,2,1,2,1,2]
Output: [2]
Example 3:

Input: n = 7, rounds = [1,3,5,7]
Output: [1,2,3,4,5,6,7]
 */

 class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < rounds.length - 1; i++){
            update(map, max, rounds[i], rounds[i+1], n);
        }
        map.put(rounds[0], map.getOrDefault(rounds[0], 0) + 1);
        max = Math.max(max, map.get(rounds[0]));
        List<Integer> res = new LinkedList<>();
        for (Integer num : map.keySet()){
            if (map.get(num) == max) res.add(num);
        }
        Collections.sort(res);
        return res;
    }
    private void update(HashMap<Integer, Integer> map, int max, int start, int end, int n){
        if (start < end){
            for (int i = start + 1; i <= end; i++){
                map.put(i, map.getOrDefault(i, 0) + 1);
                max = Math.max(max, map.get(i));
            }
        } else {
            for (int i = start + 1; i <= n; i++){
                map.put(i, map.getOrDefault(i, 0) + 1);
                max = Math.max(max, map.get(i));
            }
            for (int i = 1; i <= end; i++){
                map.put(i, map.getOrDefault(i, 0) + 1);
                max = Math.max(max, map.get(i));
            }
        }
    }
}