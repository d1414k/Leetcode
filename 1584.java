// https://leetcode.com/problems/min-cost-to-connect-all-points/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Node> pq = new PriorityQueue<Node>((Node a, Node b)->a.dist-b.dist);
        for(int i = 0 ; i < n ; i++) { 
            for(int j = i + 1 ; j < n ; j++) {
                pq.add(new Node(Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]), i, j));
            }
        }
        DisjointSet ds = new DisjointSet(n);
        int res = 0, noOfedges = 0;;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(ds.find(cur.index1) != ds.find(cur.index2)) {
                res += cur.dist;
                noOfedges++;
                if(noOfedges == n-1) return res;
                ds.union(cur.index1, cur.index2);
            }
        }
        return res;
    }
}
class DisjointSet {
    int []parent = null;
    int []rank = null;
    DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for(int i = 0 ; i < size ; i++) {
            parent[i] = i;
        }
    }
    void union(int x, int y) {
        int parentX = find(x); 
        int parentY = find(y);
        if(rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        }
        else if(rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        }
        else{
            parent[parentX] = parentY;
            rank[parentY]++;
        }
    }
    int find(int x) {
        if(parent[x] == x)
            return x;
       return parent[x] = find(parent[x]);
    }
}
class Node {
    int dist, index1, index2;
    Node(int dist, int index1,int index2) {
        this.dist = dist;
        this.index1 = index1;
        this.index2 = index2;
    }
}
/*
[[0,0],[2,2],[3,10],[5,2],[7,0]]
[[3,12],[-2,5],[-4,1]]
[[0,0],[1,1],[1,0],[-1,1]]
[[-1000000,-1000000],[1000000,1000000]]
[[0,0]]
*/
