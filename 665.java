// https://leetcode.com/problems/non-decreasing-array/

class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean modified = false;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i-1] > nums[i]){
                if(modified) {
                    return false;
                }
                modified = true;
                // can modify i-1
                // if(i == 1)
                //     nums[i-1] = Integer.MIN_VALUE;
                // else if(nums[i-2] <= nums[i])
                //     nums[i-1] = nums[i-2];
                // else // need to modify i
                //     nums[i] = nums[i-1];
                if(i > 1 && nums[i-2] > nums[i])
                    nums[i] = nums[i-1];
            }
        }
        return true;
    }
}
