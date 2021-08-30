//https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/

class Solution {
    /*
    Approach 1:
    We can compute prefix sum and apply sliding window in each diagonal
    similar to 1D array
    
    Approach 2:
    As we need to find max size square
    so we know that if any k size square already present then we can check for size k+1 onwards
    we can try for each cell as top left corner and check for size as above.
    
    TC : O(m*n)
    SC : O(1)
    */
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length, m = mat[0].length;
        //Compute prifix sum
        // first col
        for(int i = 1 ; i < n ; i++){
            mat[i][0] += mat[i-1][0];  
        }
        //first row
        for(int j = 1 ; j < m ; j++){
            mat[0][j] += mat[0][j-1];  
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                mat[i][j] += mat[i-1][j] + mat[i][j-1] - mat[i-1][j-1];
            }
        }
        int res = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                while(res <= Math.min(n-i, m-j) && squareSum(mat,i, j , i + res-1, j + res-1) <= threshold){
                    res++;
                }
            }
        }
        return res - 1;
    }
    int squareSum(int [][]mat, int x1, int y1, int x2, int y2){
        if(x1 == 0 && y1 ==0)
            return mat[x2][y2];
        if(x1 == 0)
            return mat[x2][y2] - mat[x2][y1-1];
        if(y1 == 0)
            return mat[x2][y2] - mat[x1-1][y2];
        return mat[x2][y2] - mat[x2][y1-1] - mat[x1-1][y2] + mat[x1-1][y1-1];    
    }
}
/*
[[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]]
4
[[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]]
1
[[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]]
6
[[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]]
40184
*/
