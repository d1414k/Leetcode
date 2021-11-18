// https://leetcode.com/problems/max-increase-to-keep-city-skyline/

class Solution {
    /*
    Skyline is formed by building having max height in that row or col
    depending on from where we are looking
    from left or right : formed by building having max height in that row
    from top or bottom : formed by building having max height in that column
    
    we can independly increase each building height until it is 
    smaller that height in that row and column
    if we increase more it becomes part of skyline...
    
    so we need max in each column and row
    TC : O(n^2) 
    SC : O(n)
    */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, maxRows[] = new int[n], maxColumns[] = new int[n], res = 0;
        for(int i = 0; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(maxRows[i] < grid[i][j])
                    maxRows[i] = grid[i][j];
                if(maxColumns[j] < grid[i][j])
                    maxColumns[j] = grid[i][j];
            }
        }
        for(int i = 0; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                res += Math.min(maxRows[i], maxColumns[j]) - grid[i][j];
            }
        }
        return res;
    }
}
