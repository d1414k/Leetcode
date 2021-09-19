// https://leetcode.com/problems/making-a-large-island/
class Solution {
    int []dx = {0,-1,0,1};
    int []dy = {-1,0,1,0};
    int n = 0;
    int[][] grid = null;
    DisjointSet ds;
    static int res = 1;
    public int largestIsland(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        ds = new DisjointSet(n,grid);
        res = 1;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 1) {
                    HashSet<Node> hs = new HashSet();
                    for(int k = 0 ; k < 2 ; k++) { // do union with left and top
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && ny >= 0 && grid[nx][ny] == 1) {                            
                            Node p1 = ds.find(i,j);
                            Node p2 = ds.find(nx,ny);
                            if(p1 != p2)
                                ds.union(p1.x, p1.y, p2.x,p2.y); 
                        }   
                    }  
                }
            }
        }//ds.p();
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 0)
                    res = Math.max(res,findIslandSize(i,j));
            }
        }
        return res;
    }
    // It will return Island size by making this element as 1
    int findIslandSize(int x, int y) {//System.out.println("find " +x+" "+y);
        HashSet<Node> hs = new HashSet<Node>();
        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1) {
                Node t = ds.find(nx,ny);
                hs.add(t);   
                //System.out.println(t+" test : "+t.x+" "+t.y+" size "+hs.size());
            }   
        }
        if(hs.size() == 0) return 1;
        int size = 1; // cur ele is made as 1
        for(Node p : hs) { 
            size += ds.findSize(p); //System.out.println(p+" "+p.x+" "+p.y+" size "+size);
        }
        return size;
    }
}

class DisjointSet {
    Node [][]a = null;
    int n = 0;
    DisjointSet(int n, int [][]grid) {
        this.n = n;
        a = new Node[n][n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                a[i][j] = new Node(0,0,i,j);
                a[i][j].parent = a[i][j];
                if(grid[i][j] == 1)
                    a[i][j].size++;
            }   
        }
    }
    void union(int x1, int y1, int x2, int y2) {
        Node parentA = find(x1,y1);
        Node parentB = find(x2,y2);
        if(parentA.rank < parentB.rank) {
            a[parentA.x][parentA.y].parent = parentB;
            parentB.size += parentA.size;
            Solution.res = Math.max(Solution.res, parentB.size);
        }
        else if(parentA.rank > parentB.rank) {
            a[parentB.x][parentB.y].parent = parentA;
            parentA.size += parentB.size; 
            Solution.res = Math.max(Solution.res, parentA.size);
        }
        else {
            a[parentA.x][parentA.y].parent = parentB;
            a[parentB.x][parentB.y].rank++;
            parentB.size += parentA.size; 
            Solution.res = Math.max(Solution.res, parentB.size);
        }
    }
    Node find(int x, int y) {
        if(a[x][y].parent == a[x][y]) return a[x][y];
        return a[x][y].parent = find(a[x][y].parent.x , a[x][y].parent.y);
    }
    int findSize(Node p){
        return a[p.x][p.y].size;
    }
    void p() {
       for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                System.out.print(a[i][j]+","+ a[i][j].parent+" ");
            }   
           System.out.println();
        } 
    }
}
class Node{
    Node parent;
    int size,rank,x,y;
    Node(int size, int rank, int x, int y) {
        this.size = size;
        this.rank = rank;
        this.x = x;
        this.y = y;
    }
}
/*
[[1,0],[0,1]]
[[1,0,0],[0,0,0],[0,0,0]]
[[1,0,0],[0,0,1],[0,0,0]]
[[1,1],[1,0]]
[[1,1],[1,1]]
[
[0,0,0,0,0,0,0],
[0,1,1,1,1,0,0],
[0,1,0,0,1,0,0],
[1,0,1,0,1,0,0],
[0,1,0,0,1,0,0],
[0,1,0,0,1,0,0],
[0,1,1,1,1,0,0]]


0 1 1 1 1
1 0 1 1 1
0 0 1 1 0


1 2
3 4


dfs : n^2
n^4

O(n^2logn)

2,3 2,3
2,10 2,10  . . . . 2.10 


*/
