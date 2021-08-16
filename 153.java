class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length-1;
        while(l <= h){
            int m = l + (h-l)/2;
            // [l h] is sorted
            if(nums[l] <= nums[h])
                return nums[l];
            if(m > 0 && nums[m-1] > nums[m])
                return nums[m];
            // left part is sorted
            if(nums[l] <= nums[m]){
                l = m + 1;
            }
            else{// if right part is sorted
                h = m - 1;
            }
        }
        return -1;
    }
}
// class Solution {
//     public int findMin(int[] nums) {
//         int l = 0, h = nums.length-1;
//         int res = nums[0];
//         while(l <= h){
//             int m = l + (h-l)/2;
//             if(m > 0 && nums[m-1] > nums[m])
//                 return nums[m];
//             // left part is sorted
//             if(nums[l] <= nums[m]){
//                 res = Math.min(res,nums[l]);
//                 l = m + 1;
//             }
//             else{// if right part is sorted
//                 res = Math.min(res,nums[m]);
//                 h = m - 1;
//             }
//         }
//         return res;
//     }
// }
/*
[4,5,6,7,0,1,2]
[11,13,15,17]
[3,4,5,1,2]
*/
