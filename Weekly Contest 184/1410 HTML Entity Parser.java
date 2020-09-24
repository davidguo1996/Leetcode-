/**
HTML entity parser is the parser that takes HTML code as input and replace all the entities of the special characters by the characters itself.

The special characters and their entities for HTML are:

Quotation Mark: the entity is &quot; and symbol character is ".
Single Quote Mark: the entity is &apos; and symbol character is '.
Ampersand: the entity is &amp; and symbol character is &.
Greater Than Sign: the entity is &gt; and symbol character is >.
Less Than Sign: the entity is &lt; and symbol character is <.
Slash: the entity is &frasl; and symbol character is /.
Given the input text string to the HTML parser, you have to implement the entity parser.

Return the text after replacing the entities by the special characters.

 

Example 1:

Input: text = "&amp; is an HTML entity but &ambassador; is not."
Output: "& is an HTML entity but &ambassador; is not."
Explanation: The parser will replace the &amp; entity by &
Example 2:

Input: text = "and I quote: &quot;...&quot;"
Output: "and I quote: \"...\""
Example 3:

Input: text = "Stay home! Practice on Leetcode :)"
Output: "Stay home! Practice on Leetcode :)"
Example 4:

Input: text = "x &gt; y &amp;&amp; x &lt; y is always false"
Output: "x > y && x < y is always false"
Example 5:

Input: text = "leetcode.com&frasl;problemset&frasl;all"
Output: "leetcode.com/problemset/all"

 */

 class Solution {
    HashMap<String, Character> map = new HashMap<>();
    public String entityParser(String text) {
        
        map.put("&quot;", '"');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < text.length()){
            if (text.charAt(i) == '&'){
                String parse = getParse(text, i);
                if (parse == null){
                    sb.append("&");
                    i++;
                    continue;
                }
                if (parse.equals("&apos;")){
                    sb.append("'");
                    i += 6;
                } else {
                    sb.append(map.get(parse));
                    i += parse.length();
                }
            } else {
                sb.append(text.charAt(i));
                i++;
            }
            
        }
        return new String(sb.toString());
    }
    private String getParse(String text, int index){
        for (int i = 4; i <= 7; i++){
            if (index + i <= text.length() && map.containsKey(text.substring(index, index + i))){
                return text.substring(index, index + i);
            }
            if (index + i <= text.length() && text.substring(index, index + i).equals("&apos;")){
                return text.substring(index, index + i);
            }
        }
        return null;
        
    }
}