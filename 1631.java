class Solution {
    // We can use apply binary search on solution space 
    // then can use either bfs or dfs to see if path present or not
    int[][] heights;
    boolean [][]visited;
    int row = 0,col = 0;
    int []dx = {0,0,1,-1};
    int []dy = {1,-1,0,0};
    public int minimumEffortPath(int[][] heights) {
        this.heights = heights;
        row = heights.length;
        col = heights[0].length;
        visited = new boolean[row][col];
        int l = 0, h = 1000000;
        // we can reduce this search space by calculating max diff
        int max = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                int left = i == 0 ? 0 : Math.abs(heights[i][j] - heights[i-1][j]);
                int right = i == row - 1 ? 0 : Math.abs(heights[i][j] - heights[i+1][j]);
                int up = j == 0 ? 0 : Math.abs(heights[i][j] - heights[i][j-1]);
                int down = j == col-1 ? 0 : Math.abs(heights[i][j] - heights[i][j+1]);
                left = Math.max(left,right);
                up = Math.max(up,down);
                left = Math.max(left,up);
                max = Math.max(max,left);
                
            }
        }
        h = max;
        int res = h;
        while(l <= h){
            int mid = l + (h-l)/2;
            // reset visited matrix before calling dfs
            for(int i = 0 ; i < row ; i++)
                Arrays.fill(visited[i],false);
            if(canReach(0,0,visited,mid)){
                res = mid;
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return res;
    }
    // true if we can reach to destination having <= k efforts
    // we can use dfs here
    boolean canReach(int x, int y, boolean [][]visited, int k){
        if(x == row - 1 && y == col - 1)
            return true;
        visited[x][y] = true;
        for(int i = 0 ; i < 4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nx][ny] && Math.abs(heights[x][y]-heights[nx][ny]) <= k)
                if(canReach(nx,ny,visited,k))
                    return true;
        }
        return false;
    }
}
/*
[[1,2,2],[3,8,2],[5,3,5]]
[[1,2,3],[3,8,4],[5,3,5]]
[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
*/
