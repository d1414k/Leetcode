// https://leetcode.com/problems/set-matrix-zeroes/
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstColZero = false;
        // make first row and first col as 0 if element is zero
        for(int i = 0 ; i < matrix.length ; i++){
            if(matrix[i][0] == 0)
                isFirstColZero = true;
            for(int j = 1 ; j < matrix[0].length ; j++){// start with 1 as we have associated variable for first col
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1 ; i < matrix.length ; i++){
            for(int j = 1 ; j < matrix[0].length ; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                   matrix[i][j] = 0;
                }
            }
        }
        // first row
        if(matrix[0][0] == 0)
            for(int j = 0 ; j < matrix[0].length ; j++)
                   matrix[0][j] = 0;
        
        // first col
        if(isFirstColZero)
            for(int i = 0 ; i < matrix.length ; i++)
                matrix[i][0] = 0;
    }
}
/*
[[1,1,1],[1,0,1],[1,1,1]]
[[1,2,3,4],[5,0,7,8],[0,10,11,12],[13,14,15,0]]

*/
