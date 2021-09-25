// https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int res = Integer.MAX_VALUE, n = nums.length;
        int ans = 0;
        // even index is smaller
        for(int i = 0 ; i < n ; i += 2) {
            int left = i == 0 ?  Integer.MAX_VALUE : nums[i-1];
            int right =  i == n-1 ? Integer.MAX_VALUE : nums[i+1];
            if(left > nums[i] && nums[i] < right) continue;
            ans += nums[i] - Math.min(left,right) + 1;
        }
        res = Math.min(res, ans);
        ans = 0;
        // odd index is smaller
        for(int i = 1 ; i < n ; i += 2) {
            int left = nums[i-1];
            int right =  i == n-1 ? Integer.MAX_VALUE : nums[i+1];
            if(left > nums[i] && nums[i] < right) continue;
            ans += nums[i] - Math.min(left,right) + 1;
        }
        res = Math.min(res, ans);
        return res;
    }
}
