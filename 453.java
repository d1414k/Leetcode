// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

class Solution {
    /*
    -Think in reverse of what we need to do
    -Instead of incrementing n-1 elements we can decrement exatly 1 element
    at a time
    -By this way in order to make the array equal, all elements has to be converted to
    min element of the array
    */
    public int minMoves(int[] nums) {
        int min = nums[0], res = 0;
        for(int i = 1; i < nums.length; i++) {
            if(min > nums[i])
                min = nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            res += (nums[i] - min);
        }
        return res;
    }
}
