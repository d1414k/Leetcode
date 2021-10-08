// https://leetcode.com/problems/longest-consecutive-sequence/
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        int res = 0;
        for(int x : nums) {
            hs.add(x);
        }
        for(int i = 0 ; i < nums.length ; i++) {
            if(hs.contains(nums[i]-1)) 
                continue;
            int start = nums[i];
            int end = start+1;
            while(hs.contains(end))
                end++;
            res = Math.max(res, end-start);
        }
        return res;
    }
}
