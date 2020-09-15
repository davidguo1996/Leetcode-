/**
Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.

Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

 

Example 1:



Input: root = [2,3,1,3,1,null,1]
Output: 2 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 2:



Input: root = [2,1,1,1,3,null,null,null,null,null,1]
Output: 1 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 3:

Input: root = [9]
Output: 1
 */

 class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        List<Integer> path = new ArrayList<>();
        int[] res = new int[]{0};
        helper(root, path, res);
        return res[0];
    }
    private void helper(TreeNode root, List<Integer> path, int[] res){
        if (root == null) {
            return;
        }
        if (isLeaf(root)){
            path.add(root.val);
            res[0] += isPalindrome(path);
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        helper(root.left, path, res);
        if (root.left != null && !isLeaf(root.left)){
            path.remove(path.size() - 1);
        }
        helper(root.right, path, res);
        if (root.right != null && !isLeaf(root.right)){
            path.remove(path.size() - 1);
        }
        return;
    }
    private boolean isLeaf(TreeNode root){
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        return false;
    }
    private int isPalindrome(List<Integer> path){
        if (path.size() == 0) return 0;
        HashMap<Integer, Integer> count = buildMap(path);
        if (path.size() % 2 == 0){
            for (Integer key : count.keySet()){
                if (count.get(key) % 2 != 0){
                    return 0;
                }
            }
            
        } else {
            int odd = 0;
            for (Integer key : count.keySet()){
                if (count.get(key) % 2 != 0){
                    odd++;
                }
                if (odd > 1) return 0;
            }
            if (odd != 1) return 0;
            
        }
        return 1;
    }
    private HashMap<Integer, Integer> buildMap(List<Integer> path){
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < path.size(); i++){
            Integer num = path.get(i);
            if (res.containsKey(num)){
                res.put(num, res.get(num) + 1);
            } else {
                res.put(num, 1);
            }
        }
        return res;
    }
}