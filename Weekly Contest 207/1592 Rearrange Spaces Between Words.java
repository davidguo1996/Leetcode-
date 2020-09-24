/**
You are given a string text of words that are placed among some number of spaces. Each word consists of one or more lowercase English letters and are separated by at least one space. It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized. If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.

Return the string after rearranging the spaces.

 

Example 1:

Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
Example 2:

Input: text = " practice   makes   perfect"
Output: "practice   makes   perfect "
Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. We place this extra space at the end of the string.
Example 3:

Input: text = "hello   world"
Output: "hello   world"
Example 4:

Input: text = "  walks  udp package   into  bar a"
Output: "walks  udp  package  into  bar  a "
Example 5:

Input: text = "a"
Output: "a"
 */

 class Solution {
    public String reorderSpaces(String text) {
        StringBuilder sb = new StringBuilder();
        int spaces = 0;
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == ' ') spaces++;
        }
        String[] words = text.trim().split("\\s+");
        
        if (words.length == 1) {
            sb.append(words[0]);
            for (int i = 0; i < spaces; i++) sb.append(" ");
            return sb.toString();
        }
        int n = words.length;
        int each = spaces / (n - 1);
        int remain = spaces - each * (n - 1);
        String pattern = "";
        for (int i = 0; i < each; i++) pattern += " ";
        for (int i = 0; i < words.length; i++){
            //if (words[i].charAt(0) == ' ') continue;
            sb.append(words[i]);
            if (i != words.length - 1) sb.append(pattern);
        }
        String last = "";
        for (int i = 0; i < remain; i++) last += " ";
        sb.append(last);
        return sb.toString();
    }
}