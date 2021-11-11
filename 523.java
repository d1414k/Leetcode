// https://leetcode.com/problems/continuous-subarray-sum/

class Solution {
    /*
    We can start traversing from left to right and pefixSum 
    Let say we are at index i and prefixSum is x
    then to find a subarray with sum divisible by k
    we need remove some prefix let say at index j and prefixSum y
    
    so (x-y) divisible by k
    => x%k - y%k divisible by k 
    => x%k - y%k = 0 because both are less than k
    => we can save prefix sum %k and if we get same no again and index diff >=2 then true
    */
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        int n = nums.length, preSum = 0;
        map.put(0,-1); // if subarray[0,i] is divisible by k 
        for(int i = 0 ; i < n ; i++) {
            preSum += nums[i];
            preSum %= k;
            if(map.containsKey(preSum)){
                if(i - map.get(preSum) >= 2)
                    return true;
            }
            else
                map.put(preSum,i);
        }
        return false;
    }
}
