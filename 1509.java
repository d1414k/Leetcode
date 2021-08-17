// class Solution {// using sorting 14ms
//     public int minDifference(int[] nums) {
//         int n = nums.length;
//         if(n - 3 < 2)  // we can make all element to same value
//             return 0;
//         Arrays.sort(nums);
//         // now we can replace total 3 elements from both end
//         int x = n - 3, res = Integer.MAX_VALUE;
//         for(int i = 0 ; i < 4 ; i++){
//             res = Math.min(res, nums[i+x-1] - nums[i]);
//         }
//         return res;
//     }
// }
class Solution {// Using Priority Queue. 29ms
    static int []min4 = new int[4];
    static PriorityQueue<Integer> maxPriority = new PriorityQueue(5,Collections.reverseOrder());
    // holds min 4 elements
    static PriorityQueue<Integer> minPriority = new PriorityQueue(5);
    // holds max 4 elements
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n - 3 < 2)  // we can make all element to same value
            return 0;
        int res = Integer.MAX_VALUE;
        for(int x : nums){
            maxPriority.add(x);
            minPriority.add(x);
            if(maxPriority.size() > 4) maxPriority.poll();
            if(minPriority.size() > 4) minPriority.poll();
        }
        for(int i = 3 ; i >= 0 ; i--) 
            min4[i] = maxPriority.poll();
        for(int i = 0 ; i < 4 ; i++) 
            res = Math.min(res, minPriority.poll() - min4[i]);
        return res;
    }
}
/*
[5,3,2,4]
[1,5,0,10,14]
[6,6,0,1,1,4,6]
[1,5,6,14,15]
*/
