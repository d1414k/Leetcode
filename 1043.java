// https://leetcode.com/problems/partition-array-for-maximum-sum/
class Solution {
    public int maxSumAfterPartitioning(int[] a, int k) {
        int n = a.length;
        int []dp = new int[n+1];
        for(int i = 1 ; i <= n ; i++) {
            for(int sizeOfWindow = 1, max = a[i-1] ; sizeOfWindow <= k && sizeOfWindow <= i ; sizeOfWindow++) {
                max = Math.max(max,a[i-sizeOfWindow]);
                dp[i] = Math.max(dp[i], max*sizeOfWindow + dp[i-sizeOfWindow]);
            }
        }
        return dp[n];
    }
}
// class Solution {
//     int []dp = null;
//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         dp = new int[arr.length+1];
//         Arrays.fill(dp,-1);
//         return helper(arr,arr.length,k);
//     }
    
//     int helper(int []a, int n, int k) {
//         if(n == 0) return 0;
//         if(dp[n] != -1) return dp[n];
//         int res = 0;
//         for(int sizeOfWindow = 1, max = a[n-1] ; sizeOfWindow <= k && sizeOfWindow <= n ; sizeOfWindow++) { 
//             max = Math.max(max,a[n-sizeOfWindow]);
//             res = Math.max(res, max*sizeOfWindow + helper(a,n-sizeOfWindow,k));
//         }
//         return dp[n] = res;
//     }
// }
/*
[1,15,7,9,2,5,10]
3
[1,4,1,5,7,3,6,1,9,9,3]
4
[1]
1
*/
