// https://codingcompetitions.withgoogle.com/kickstart/round/0000000000436140/000000000068c509#problem
import java.util.*;
public class Solution {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    MySolution ms = new MySolution();
	    for(int x = 1 ; x <= t ; x++) {
	        int r = sc.nextInt();
	        int c = sc.nextInt();
	        int [][]a = new int[r][c];
	        for(int i = 0 ; i < r ; i++) {
	            for(int j = 0 ; j < c ; j++){
	                a[i][j] = sc.nextInt();
	            }
	        }
	        System.out.println("Case #"+x+": "+ ms.calculate(a));
	    }
	}
}

class MySolution {
    int calculate(int [][]a) {
        int n = a.length, m = a[0].length, res = 0;
        int [][][]dp = new int[n][m][4]; // 0 = Left,1 = Down, 2 = Right, 3 = Up
        // Update
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(a[i][j] == 0) continue;
                dp[i][j][0] = dp[i][j][3] = a[i][j];
                // update left
                if(j > 0) dp[i][j][0] += dp[i][j-1][0];
                // update Up
                if(i > 0 ) dp[i][j][3] += dp[i-1][j][3];
            }
        }
        for(int i = n-1 ; i >= 0 ; i--) {
            for(int j = m-1 ; j >= 0 ; j--) {
                if(a[i][j] == 0) continue;
                dp[i][j][1] = dp[i][j][2] = a[i][j];
                // update Right
                if(j < m-1) dp[i][j][2] += dp[i][j+1][2];
                // update Down
                if(i < n-1) dp[i][j][1] += dp[i+1][j][1];
            }
        }
        // calculate
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(a[i][j] == 0) continue;
                // Left Down : 0 ,1
                res += lShapeCount(dp[i][j][0],dp[i][j][1]); 
                res += lShapeCount(dp[i][j][1],dp[i][j][2]);
                res += lShapeCount(dp[i][j][2],dp[i][j][3]);
                res += lShapeCount(dp[i][j][0],dp[i][j][3]);
            }
        }
        return res;
    }
    // this will return no of L shape that can b form with respective side length a,b
    int lShapeCount(int a, int b) {
        if(a < 2 || b < 2) return 0;
        // 2 3 4 5 ...k one side length
        int x = Math.min(a,b/2) - 2 + 1;
        int y = Math.min(b,a/2) - 2 + 1;
        int z = (x > 0 ? x : 0) + (y > 0 ? y : 0);
        return z;
    }
}
