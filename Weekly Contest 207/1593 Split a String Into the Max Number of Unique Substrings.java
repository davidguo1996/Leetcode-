/**
Given a string s, return the maximum number of unique substrings that the given string can be split into.

You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "ababccc"
Output: 5
Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
Example 2:

Input: s = "aba"
Output: 2
Explanation: One way to split maximally is ['a', 'ba'].
Example 3:

Input: s = "aa"
Output: 1
Explanation: It is impossible to split the string any further.
 */

 class Solution {
    private int[] res = new int[]{0};
    public int maxUniqueSplit(String s) {
        dfs(s, 0, new HashSet<String>(), 0);
        return res[0];
    }
    private void dfs(String s, int index, Set<String> set, int cur){
        if (index == s.length()) {
            res[0] = Math.max(cur, res[0]);
            return;
        }
        for (int i = index; i < s.length(); i++){
            String curs = s.substring(index, i + 1);
            if (!set.contains(curs)){
                set.add(curs);
                dfs(s, i + 1, set, cur + 1);
                set.remove(curs);
                
            }
        }
    }
}