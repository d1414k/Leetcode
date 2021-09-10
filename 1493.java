// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

class Solution { // Method 2
    public int longestSubarray(int[] nums) {
        int prevCount = 0, curCount = 0, maxCount  = 0;
        boolean isZeroExists = false; 
        for(int x : nums){
           if(x == 0){
               maxCount = Math.max(maxCount, curCount + prevCount);
               prevCount = curCount;
               curCount = 0;
               isZeroExists = true;
           }else{
               curCount++;
           }
        }
        maxCount = Math.max(maxCount, curCount + prevCount);
        return isZeroExists ? maxCount : curCount - 1; //need to delete 1 element
    }
}
// class Solution { Method 1
//     public int longestSubarray(int[] nums) {
//         int ans = 0;
//         if(nums == null || nums.length == 0)
//             return ans;
//         int count = 0;
//         for(int i = 0 ; i < nums.length ; i++){
//             if(nums[i] == 0){
//                 nums[i] = -count;
//                 count = 0;
//             }else{
//                 count++;
//                 if(count - 1 > ans)
//                     ans = count - 1;
//             }
//         }
//         count = 0;
//         for(int i = nums.length - 1 ; i >= 0 ; i--){
//             if(nums[i] <= 0){
//                 if(-nums[i] + count > ans)
//                     ans = -nums[i] + count;
//                 count = 0;
//             }else{
//                 count++;
//             }
//         }
//         return ans;
//     }
// }
