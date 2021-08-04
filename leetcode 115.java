// https://leetcode.com/problems/distinct-subsequences/

class Solution {
    int [][]dp;
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        dp = new int[2][m+1];
        // init
        dp[0][0] = dp[1][0] = 1;
        for(int i = 1 ; i <= n ; i++) {
            int i1 = i%2, i2 = (i-1)%2;// map to first or second row
            for(int j = 1 ; j <= i && j <= m ; j++) { // j > i ie, O 
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i1][j] = dp[i2][j] + dp[i2][j-1];
                }
                else {
                    dp[i1][j] = dp[i2][j];
                }
            }
        }
        return dp[n%2][m];
    }
}
/*
3
s : rabbbit
t : rabbit
n = 7
m = 6

f(n,m) =    s[n-1] == t[m-1]    f(n-1,m-1) + f(n-1,m)  
            s[n-1] != t[m-1]    f(n-1,m)
            m == 0              1
            n == 0 && m > 0     0
            m > n               0
            
f(7,6) = f(6,5) + f(6,6) = 3 + 0 = 3 
f(6,6) = f(5,6) = 0
f(6,5) = f(5,4) + f(5,5) = 3 + 0 = 3 
f(5,4) = f(4,3) + f(4,4) = 2 + 1 = 3
f(5,5) = f(4,5) = 0
f(4,3) = f(3,3) + f(3,2) = 1 + 1 = 2
f(4,4) = f(3,4) + f(3,2) = 0 + 1 = 1 
f(3,3) = f(2,3) + f(2,2) = 0 + 1 = 1
f(3,2) = f(2,2) = 1
f(3,4) = 0
f(2,3) = 0
f(2,2) = f(1,2) + f(1,1) = 0 + 1 = 1
f(1,1) = f(0,1) + f(0,0) = 0 + 1 = 1  

*/
