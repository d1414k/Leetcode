// https://leetcode.com/problems/count-square-submatrices-with-all-ones/
class Solution {
    public int countSquares(int[][] matrix) {
        int res = 0;
        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(i == 0 || j == 0) {
                    res += matrix[i][j];  
                    continue;
                }
                if(matrix[i][j] == 1)
                    matrix[i][j] = 1 + min3(matrix[i-1][j],matrix[i][j-1],matrix[i-1][j-1]); 
                res += matrix[i][j]; 
            }
        }
        return res;
    }
    int min3(int x, int y, int z){
        return Math.min(x,Math.min(y,z));
    }
}
