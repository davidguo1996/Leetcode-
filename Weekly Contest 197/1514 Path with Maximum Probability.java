/**
You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

 

Example 1:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
Example 2:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
Output: 0.30000
Example 3:



Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
Output: 0.00000
Explanation: There is no path between 0 and 2.
 */

 class Solution {
    class Edge{
        int node;
        double prob;
        double cur;
        public Edge(int node, double prob){
            this.node = node;
            this.prob = prob;
            this.cur = 1;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] res = new double[]{0};
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Edge>> map = buildMap(edges, succProb);
        PriorityQueue<Edge> minheap = new PriorityQueue<>(new Comparator<Edge>(){
            @Override
            public int compare(Edge one, Edge two){
                if (one.prob == two.prob) return 0;
                return one.prob < two.prob ? -1 : 1;
            }
        });
        Edge startE = new Edge(start, 0);
        startE.cur = 1;
        minheap.offer(startE);
        while (!minheap.isEmpty()){
            Edge cur = minheap.poll();
            visited[cur.node] = true;
            if (cur.node == end) return cur.cur;
            if (map.containsKey(cur.node)){
                for (Edge e : map.get(cur.node)){
                    if (!visited[e.node]){
                        Edge dest = new Edge(e.node, cur.prob - Math.log(e.prob));
                        dest.cur = cur.cur * e.prob;
                        minheap.offer(dest);
                    }
                }
            }
        }
        
        //dfs(start, end, 1, map, visited, res);
        return 0;
    }
    private HashMap<Integer, List<Edge>> buildMap(int[][] edges, double[]succProb){
        HashMap<Integer, List<Edge>> res = new HashMap<>();
        for (int i = 0; i < edges.length; i++){
            if (!res.containsKey(edges[i][0])) res.put(edges[i][0], new LinkedList<Edge>());
            if (!res.containsKey(edges[i][1])) res.put(edges[i][1], new LinkedList<Edge>());
            res.get(edges[i][0]).add(new Edge(edges[i][1], succProb[i]));
            res.get(edges[i][1]).add(new Edge(edges[i][0], succProb[i]));
        }
        return res;
    }
    private void dfs(int start, int end, double cur, HashMap<Integer, List<Edge>> map, boolean[] visited, double[] res){
        if (start == end) {
            res[0] = Math.max(res[0], cur);
            return;
        }
        if (!map.containsKey(start)) return;
        for (Edge e : map.get(start)){
            if (!visited[e.node]){
                visited[e.node] = true;
                dfs(e.node, end, cur * e.prob, map, visited, res);
                visited[e.node] = false;
            }
        }
    }
}