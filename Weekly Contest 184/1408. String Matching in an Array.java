/**
Given an array of string words. Return all strings in words which is substring of another word in any order. 

String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].

 

Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Example 2:

Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
Example 3:

Input: words = ["blue","green","bu"]
Output: []
 */

 class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j < words.length; j++){
                if (i == j){
                    continue;
                }
                if (words[i].length() <= words[j].length() && match(words[i], words[j])){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
    private boolean match(String one, String two){
        for (int i = 0; i <= two.length() - one.length(); i++){
            if (two.substring(i, i + one.length()).equals(one)){
                return true;
            }
        }
        return false;
    }
}