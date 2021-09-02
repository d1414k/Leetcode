// https://leetcode.com/problems/rotate-image/

class Solution {
    /*
    Row wise Rotation + transpose + Row wise rotation => antoclockwise 90 degree
    transpose + Row wise rotation => clockwise 90 degree
    */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i; j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        // Row wise rotation
        for(int i = 0 ; i < n ; i++){
            int l = 0, h = n-1;
            while(l < h){
                int t = matrix[i][l];
                matrix[i][l] = matrix[i][h];
                matrix[i][h] = t;
                l++;
                h--;
            }
        }
    }
}
