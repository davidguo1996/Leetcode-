/**
ou are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

 

Example 1:



Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation:

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18
Example 3:

Input: points = [[0,0],[1,1],[1,0],[-1,1]]
Output: 4
Example 4:

Input: points = [[-1000000,-1000000],[1000000,1000000]]
Output: 4000000
Example 5:

Input: points = [[0,0]]
Output: 0
 */

 class Solution {
    class Edge{
        int start, end, cost;
        public Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    int[][] points;
    class UnionFind{
        int[] parents, rank;
        public UnionFind(int n){
            this.parents = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < parents.length; i++) parents[i] = i;
        }
        public int find(int id){
            if (id != parents[id]){
                parents[id] = find(parents[id]);
            }
            return parents[id];
        }
        public boolean union(int one, int two){
            int onep = find(one), twop = find(two);
            if (onep == twop) return false;
            if (rank[onep] > rank[twop]) parents[twop] = parents[onep];
            else if (rank[twop] > rank[onep]) parents[onep] = parents[twop];
            else {
                parents[onep] = parents[twop];
                rank[twop]++;
            }
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        this.points = points;
        int res = 0;
        UnionFind uf = new UnionFind(points.length);
        PriorityQueue<Edge> minheap = makeHeap();
        while(!minheap.isEmpty()){
            Edge cur = minheap.poll();
            if (uf.find(cur.start) != uf.find(cur.end)) {
                res += cur.cost;
                uf.union(cur.start, cur.end);
            }
        }
        return res;
    }
    private PriorityQueue<Edge> makeHeap(){
        PriorityQueue<Edge> minheap = new PriorityQueue<>(new Comparator<Edge>(){
            @Override
            public int compare(Edge one, Edge two){
                return one.cost - two.cost;
            }
        });
        for (int i = 0; i < points.length; i++){
            for (int j = i + 1; j < points.length; j++){
                int dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                Edge e = new Edge(i, j, dis);
                minheap.offer(e);
            }
        }
        return minheap;
    }
}