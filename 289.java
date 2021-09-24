// https://leetcode.com/problems/game-of-life/

class Solution {
    /*
    I am going to solve this in place
    0 1 are already reserve
    we can use 2 and 3 for new 0 and 1 respectively.
    
    */
    int []dx = {0,0,1,-1,1,1,-1,-1};
    int []dy = {1,-1,0,0,1,-1,1,-1};
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        for(int i = 0 ; i < n ; i++) { 
            for(int j = 0; j < m; j++) {
                int count = 0;
                for(int k = 0 ; k < 8 ; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && (board[nx][ny] == 1 || board[nx][ny] == 2))
                        count++;
                }
                if(board[i][j] == 0 && count == 3)
                    board[i][j] = 3;
                if(board[i][j] == 1 && (count < 2 || count > 3))
                    board[i][j] = 2;
            }
        }
        for(int i = 0 ; i < n ; i++) { 
            for(int j = 0; j < m; j++) {
                if(board[i][j] >= 2)
                    board[i][j] -= 2;
            }
        }
    }
}
