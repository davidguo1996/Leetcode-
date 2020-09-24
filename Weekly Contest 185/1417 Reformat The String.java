/**
Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.

 

Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.
Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.
Example 4:

Input: s = "covid2019"
Output: "c2o0v1i9d"
Example 5:

Input: s = "ab123"
Output: "1a2b3"
 */

 class Solution {
    public String reformat(String s) {
        HashMap<Character, Integer> cmap = new HashMap<>();
        HashMap<Character, Integer> dmap = new HashMap<>();
        int cnum = 0;
        int dnum = 0;
        for (char c : s.toCharArray()){
            if (Character.isDigit(c)){
                addToMap(dmap, c);
                dnum++;
            } else {
                addToMap(cmap, c);
                cnum++;
            }
        }
        if (Math.abs(cnum - dnum) > 1){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int round = 0;
        HashMap<Character, Integer> bigMap = dnum >= cnum ? dmap : cmap;
        HashMap<Character, Integer> smallMap = dnum >= cnum ? cmap : dmap;
        
        
        for (int i = 0; i < s.length(); i++){
            Character cur = ' ';
            if (round == 0 ){
                cur = getKey(bigMap);
                remove(bigMap, cur);
                round = 1;    
            } else {
                cur = getKey(smallMap);
                remove(smallMap, cur);
                round = 0;
                
            }
            sb.append(cur);
        }
        return new String(sb.toString());
    }
    private Character getKey(HashMap<Character, Integer> map){
        for (Character c : map.keySet()){
            return c;
        }
        return null;
    }
    private void addToMap(HashMap<Character, Integer> map, Character c){
        if (!map.containsKey(c)){
            map.put(c, 1);
        } else {
            map.put(c, map.get(c) + 1);
        }
    }
    private void remove(HashMap<Character, Integer> map, Character c){
        int num = map.get(c);
        if (num > 1){
            map.put(c, num - 1);
        } else {
            map.remove(c);
        }
    }
}