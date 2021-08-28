// https://leetcode.com/problems/combination-sum-iv/

// class Solution {
//     int []dp = null;
//     public int combinationSum4(int[] nums, int target) {
//         dp = new int[target+1];
//         Arrays.fill(dp,-1);
//         return helper(nums,target);
//     }
//     int helper(int []nums, int target){ //p(target+"");
//         if(target < 0)
//             return 0;
//         if(target == 0)
//             return 1;
//         if(dp[target] != -1) return dp[target];
//         int res = 0;
//         for(int i = 0 ; i < nums.length ; i++){
//             swap(nums,0,i);
//             res += helper(nums,target-nums[0]);
//             swap(nums,0,i);
//         }
//         return dp[target] = res;
//     }
//     void swap(int []a, int i,int j){
//         int t = a[i];
//         a[i] = a[j];
//         a[j] = t;
//     }
//     void p(String s){
//         System.out.println(s);
//     }
// }

class Solution {
    int []dp = null;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp,-1);
        return helper(nums,target);
    }
    int helper(int []nums, int target){
        if(target < 0)
            return 0;
        if(target == 0)
            return 1;
        if(dp[target] != -1) return dp[target];
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++){
            res += helper(nums,target-nums[i]);
        }
        return dp[target] = res;
    }
}
