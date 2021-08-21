// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
class Solution {
    // DFS with caching
    // As we know that two cell have edge once if they are in strictly increasing order
    // so there will not be cycle in dfs
    // we need not to use visited set at all
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int [][]cache = new int[n][m];// default value 0 means not yet calculated
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                res = Math.max(res, dfs(i,j,matrix,cache));
            }
        }
        return res;
    }
    int []dx = {0,0,1,-1};
    int []dy = {1,-1,0,0};
    int dfs(int x, int y, int [][]matrix, int [][]cache){
        if(cache[x][y] != 0) return cache[x][y];
        int res = 0;
        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length && matrix[x][y] < matrix[nx][ny]){
                res = Math.max(res, dfs(nx,ny,matrix,cache));          
            }
        }
        return cache[x][y] = ++res;// ++because current cell also be present
    }
}
