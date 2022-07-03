
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int direction = 0, res = 1;
        
        for(int i = 1 ; i < nums.length ; i++) {
            int curDirection = nums[i-1] == nums[i] ? 0 : (nums[i-1] < nums[i]) ? -1 : 1;
            if(curDirection != 0 && curDirection != direction) {
                res++;
                direction = curDirection; 
            }
        }
        return res;
    }
}
