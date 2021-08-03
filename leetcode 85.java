// https://leetcode.com/problems/maximal-rectangle/
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length,area = 0;
        int []height = new int[m];
        int []left = new int[m];
        int []right = new int[m];
        Arrays.fill(right, m);
        
        for(int i = 0 ; i < n ; i++){
            int cur_left = 0, cur_right = m;
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }else{
                    height[j] = 0;
                }
            } //System.out.println("H : "+ Arrays.toString(height));
            // update left
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == '1'){
                    left[j] = Math.max(left[j],cur_left);
                }else{
                    left[j] = 0;
                    cur_left = j+1;
                }
            } //System.out.println("L : "+ Arrays.toString(left));
            // update right
            for(int j = m-1 ; j >= 0 ; j--){
                if(matrix[i][j] == '1'){
                    right[j] = Math.min(right[j],cur_right);
                }else{
                    right[j] = m;
                    cur_right = j;
                }
            }//System.out.println("R : "+ Arrays.toString(right)+"\n");
            // update area
            for(int j = 0 ; j < m ; j++){   
                area = Math.max(area, (right[j]-left[j])*height[j]);
            }
        }
        return area;
    }
}
/*
["1","0","1","0","0"]
["1","0","1","1","1"]
["1","1","1","1","1"]
["1","0","0","1","0"]


[["0","1"]]
*/
