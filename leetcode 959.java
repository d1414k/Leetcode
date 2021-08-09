// https://leetcode.com/d1414k/
// https://leetcode.com/problems/regions-cut-by-slashes/
class Solution {
    public int regionsBySlashes(String[] grid) { // based on solution
        int rows = grid.length;
        int cols = grid[0].length();
        DisjointSet ds = new DisjointSet(rows*cols*4);
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                int root = (i*cols + j)*4;
                char ch = grid[i].charAt(j);
                if(ch == '/'){
                    ds.union(root,root+3);
                    ds.union(root+1,root+2);
                }
                else if(ch == '\\'){
                    ds.union(root,root+1);
                    ds.union(root+2,root+3);      
                }else{
                    ds.union(root,root+1);
                    ds.union(root+1,root+2);
                    ds.union(root+2,root+3);
                }
                //right
                if(j < cols - 1){
                    int right = (i*cols + j+1)*4;
                    ds.union(root+1,right+3);
                }
                // left
                if(j > 0){
                    int left = (i*cols + j-1)*4;
                    ds.union(root+3,left+1);
                }
                // up
                if(i > 0){
                    int up = ((i-1)*cols + j)*4;
                    ds.union(root,up+2);
                }
                // down
                if(i < rows - 1){
                    int down = ((i+1)*cols + j)*4;
                    ds.union(root+2, down);
                }
            }
        }
        return ds.countSets();
    }
}
class DisjointSet{
    int []parent;
    int []rank;
    int size = 0;
    DisjointSet(int size){
        this.size = size;
        parent = new int[size];
        rank = new int[size];
        for(int i = 0 ; i < size ; i++){
            parent[i] = i;
        }
    }
    void union(int x,int y){
        int parent_x = find(x);
        int parent_y = find(y);
        if(rank[parent_x] < rank[parent_y]){
            parent[parent_x] = parent_y;
        }else if(rank[parent_x] > rank[parent_y]){
            parent[parent_y] = parent_x;
        }
        else{
            parent[parent_y] = parent_x;
            rank[parent_x]++;
        }
    }
    int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
    int countSets(){
        int count = 0;
        for(int i = 0 ; i < size ; i++){
            if(parent[i] == i)
                count++;
        }
        return count;
    }
}
// class Solution {
//     public int regionsBySlashes(String[] grid) {
//         int n = grid.length;
//         int m = grid[0].length();
//         boolean [][]dp = new boolean[n][m];// true means attached to boundary
//         int count = 1;
//         if(grid[0].charAt(0) == '\\' || grid[0].charAt(0) == '/')
//             dp[0][0] = true;
//         if(grid[0].charAt(0) == '/') 
//            count++;
//         // update first row
//         for(int j = 1 ; j < m ; j++){
//             char ch = grid[0].charAt(j);
//             if(ch == '\\'){
//                 dp[0][j] = true; 
//             }
//             else if(ch == '/'){
//                 dp[0][j] = true;
//                 if(grid[0].charAt(j-1) == '\\')
//                     count++;
//             }
//             if(j == m-1 && grid[0].charAt(j) == '\\')
//                count++;
                
//         }System.out.println("before "+count);
//         for(int i = 1 ; i < n ; i++){
//             for(int j = 0 ; j < m ; j++){
//                 char ch = grid[i].charAt(j);
//                 if(ch == '\\'){
//                     if(grid[i-1].charAt(j) == '/')
//                         dp[i][j] |= dp[i-1][j];
//                     if(j > 0 && grid[i-1].charAt(j-1) == '\\')
//                         dp[i][j] |= dp[i-1][j-1];
//                 }
//                 else if(ch == '/'){
//                     if(grid[i-1].charAt(j) == '\\')
//                         dp[i][j] |= dp[i-1][j];
//                     if(j+1 < m && grid[i-1].charAt(j+1) == '/')
//                         dp[i][j] |= dp[i-1][j+1];
//                     if(j > 0 && grid[i].charAt(j-1) == '\\' && dp[i][j-1] && dp[i][j])
//                         count++;
//                 }
//                 if((j == 0 || j == m-1 || i == n-1) && dp[i][j])
//                     count++;
//                 System.out.println(i+" "+j+" "+ dp[i][j]+" "+count);
                
//             }  
//         }
//         //p(dp);
//         return count;
//     }
//     void p(boolean [][]dp){
//         for(int i = 0 ; i < dp.length ; i++){
//             System.out.println(Arrays.toString(dp[i])+"");
//         }
//     }
// }
/*

[" /","/ "]
[" /","  "]
["\\/","/\\"]
["/\\","\\/"]
["//","/ "]
*/           
