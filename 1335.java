// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
class Solution {
    public static final int MAX = 10001;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(d > n) return -1;
        
        int [][]dp = new int[n+1][d+1];
        //init
        for(int i = 1 ; i <= n ; i++) {
            dp[i][0] = MAX;
        }
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= d && j <= i ; j++){
                int res = MAX;
                for(int windowSize = 1, max = 0 ; windowSize <= i - j + 1 ; windowSize++) {
                    max = Math.max(max, jobDifficulty[i - windowSize]);
                    res = Math.min(res, max + dp[i-windowSize][j-1]);
                }
                dp[i][j] = res;
            }
        }
        return dp[n][d] == MAX ? -1 : dp[n][d];
    }
}
// class Solution {
//     public static final int MAX = 10001;
//     public int minDifficulty(int[] jobDifficulty, int d) {
//         int n = jobDifficulty.length;
//         int [][]dp = new int[n+1][d+1];
//         for(int i = 0 ; i <= n ; i++) {
//             Arrays.fill(dp[i],-1);
//         }
//         int res = helper(jobDifficulty, n, d,dp);
//         return res == MAX ? -1 : res;
//     }
    
//     int helper(int []a, int n, int d,int [][]dp) { //System.out.println(n+" "+d);
//         if(d == 0){
//             if(n == 0)
//                 return 0;
//             return MAX;
//         }
//         if(d > n)
//             return MAX;
//         if(dp[n][d] != -1) return dp[n][d];
//         int res = MAX;
//         for(int windowSize = 1, max = 0 ; windowSize <= n - d + 1 ; windowSize++) {
//             max = Math.max(max,a[n-windowSize]);
//             res = Math.min(res, max + helper(a, n - windowSize, d-1, dp));
//         }
//         return dp[n][d] = res;
//     }
// }
