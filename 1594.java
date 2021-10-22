// https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long pos[][] = new long[n][m], neg[][] = new long[n][m];
        pos[n-1][m-1] = neg[n-1][m-1] = grid[n-1][m-1];
        // last row
        for(int j = m-2 ; j >= 0 ; j--) {
            pos[n-1][j] = neg[n-1][j] = grid[n-1][j]*pos[n-1][j+1];
        }
        // last col
        for(int i = n-2 ; i >=0  ; i--) {
            pos[i][m-1] = neg[i][m-1] = grid[i][m-1]*pos[i+1][m-1];
        }
        for(int i = n-2 ; i >= 0 ; i--) {
            for(int j = m-2 ; j >= 0 ; j--) {
                long maxPos = Math.max(pos[i][j+1], pos[i+1][j]);
                long minNeg = Math.min(neg[i][j+1], neg[i+1][j]);
                if(grid[i][j] >= 0 ){
                    pos[i][j] = grid[i][j]*maxPos;
                    neg[i][j] = grid[i][j]*minNeg;
                }
                else{
                    pos[i][j] = grid[i][j]*minNeg;
                    neg[i][j] = grid[i][j]*maxPos;;
                }
            }
        }
        return (int)(pos[0][0] < 0 && neg[0][0] < 0 ? -1 : Math.max(pos[0][0], neg[0][0]) % 1000000007);
    }
}
