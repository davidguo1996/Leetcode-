/**
There are n cities numbered from 0 to n-1 and n-1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [a, b] represents a road from city a to b.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach the city 0 after reorder.

 

Example 1:



Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:



Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 3:

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0
 */

 class Solution {
    // 1(f) -> 2(t)
    // travese: 2(t) -> 1(f)
    class Node {
        int val;
        List<Node> nei;
        List<Boolean> exist;
        public Node(int val){
            this.val = val;
            this.nei = new ArrayList<Node>();
            this.exist = new ArrayList<Boolean>();
        }
    }
    public int minReorder(int n, int[][] connections) {
        
        Node root = buildTree(connections);
        int res = 0;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()){
            Node cur = q.poll();
            visited.add(cur.val);
            for (int i = 0; i < cur.nei.size(); i++){
                Node curNei = cur.nei.get(i);
                if (!visited.contains(curNei.val)){
                    q.offer(curNei);
                    if (!cur.exist.get(i)) res++;
                }
            }
        }
        return res;
    }
    private Node buildTree(int[][] edges){
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++){
            if (!map.containsKey(edges[i][0])){
                map.put(edges[i][0], new Node(edges[i][0]));
            }
            if (!map.containsKey(edges[i][1])){
                map.put(edges[i][1], new Node(edges[i][1]));
            }
            Node from = map.get(edges[i][0]);
            Node to = map.get(edges[i][1]);
            from.nei.add(to);
            to.nei.add(from);
            from.exist.add(false);
            to.exist.add(true);
        }
        return map.get(0);
    }
}