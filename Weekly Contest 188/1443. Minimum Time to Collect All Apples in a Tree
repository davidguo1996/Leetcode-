/**
Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend in order to collect all apples in the tree starting at vertex 0 and coming back to this vertex.

The edges of the undirected tree are given in the array edges, where edges[i] = [fromi, toi] means that exists an edge connecting the vertices fromi and toi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple, otherwise, it does not have any apple.

 

Example 1:



Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
Output: 8 
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  
Example 2:



Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
Output: 6
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  
Example 3:

Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
Output: 0
 */

 class Solution {
    // set(), remain
    // bfs: queue, findChildren(), path
    //
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        TreeNode root = buildTree(edges, hasApple);
        
        return dfs(root);
    }
    private int dfs(TreeNode root){
        int totalDis = 0;
        for (TreeNode cur : root.child){
            int dis = dfs(cur);
            if (dis != 0) {
                totalDis += dis + 2;
                continue;
            }
            if (cur.isApple){
                totalDis += 2;
            }
        }
        return totalDis;
    }
    
    private TreeNode buildTree(int[][] edges, List<Boolean> hasApple){
        TreeNode root = new TreeNode(0);
        HashSet<Integer> set = new HashSet<>();
        int m = 0;
        for (Boolean app : hasApple){
            if (app) set.add(m);
            m++;
        }
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++){
            if (!map.containsKey(edges[i][0])){
                TreeNode cur = new TreeNode(edges[i][0]);
                map.put(cur.val, cur);
                if (set.contains(cur.val)) cur.isApple = true;
                if (cur.val == 0) root = cur;
            }
            if (!map.containsKey(edges[i][1])){
                TreeNode cur = new TreeNode(edges[i][1]);
                map.put(cur.val, cur);
                if (set.contains(cur.val)) cur.isApple = true;
            }
            map.get(edges[i][0]).addChild(map.get(edges[i][1]));
        }
        return root;
    }
    class TreeNode{
        int val;
        boolean isApple;
        List<TreeNode> child;
        int distance;
        public TreeNode(int val){
            this.val = val;
            this.child = new LinkedList<>();
            this.isApple = false;
        }
        public void addChild(TreeNode chi){
            this.child.add(chi);
        }
    }
}