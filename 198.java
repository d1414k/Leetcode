// https://leetcode.com/problems/house-robber/
class Solution {
    public int rob(int[] nums) {
        // we can use dp 
        // we need dp array of size n
        // dp[n] = a[n-1] + dp[n-2] , dp[n-1]
        // we can see we only previous 2 values
        int n = nums.length, dp_2 = 0, dp_1 = nums[0], dp = dp_1;
        for(int i = 2 ; i <= n ; i++) {
            dp = Math.max(nums[i-1] + dp_2, dp_1);
            dp_2 = dp_1;
            dp_1 = dp;
        }
        return dp;
    }
}
// TC : O(n)
// SC : O(1)
