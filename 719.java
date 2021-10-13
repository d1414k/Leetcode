// https://leetcode.com/problems/find-k-th-smallest-pair-distance/

class Solution {
    /*
    sort array
    Apply binary search on ans
    */
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums); //System.out.println(Arrays.toString(nums));
        int min = Integer.MAX_VALUE, max = nums[n-1]-nums[0];
        for(int i = 0 ; i < n-1 ; i++) {
            if(min > nums[i+1]-nums[i])
                min = nums[i+1]-nums[i];
        }
        int l = min, h = max, res = -1;
        while(l <= h) {
            int mid = l + (h-l)/2;
            int noOfSmallerOrEqualPairs = find(nums,mid);
            //System.out.println(l+" "+mid+" "+h+" "+noOfSmallerOrEqualPairs);
            if(noOfSmallerOrEqualPairs >= k){
                h = mid - 1;
                res = mid;
            }
            else
                l = mid + 1;
            
        }
        return res;
    }
    int find(int []nums, int x) {
        int n = nums.length, i = 0, j = 1, count = 0;
        while(j < n) {
            if(nums[j] - nums[i] <= x){
                j++;
            }
            else{
                count += j - i - 1; //System.out.println(i+" "+j+" "+count);
                i++;
                if(i == j) // it should be pair so at leat 1 distance
                    j++;
            }
        }
        if(i < n-1){
            count += ((n-i)*(n-i-1))/2;
        }
        return count;
    }
}
// class Solution { // wrong approach
//     /*
//     sort given array
//     now we can generate differences from dist 1 to n, here dist means index difference ie, j-i
//                           cummulative sum
//     1 dist pairs : n-1          n-1
//     2 dist pairs : n-2          2n-3
//     3 dist pairs : n-3          3n-6
    
//     d dist.        n-d.   dn-(1+2+3+...d) = d*n + d(d+1)/2
    
//     Now we need to find such d which satsfies following
    
//     d-1 dist pairs cummulative sum < k <=  d dist pairs cummulative sum
//     */
//     public int smallestDistancePair(int[] nums, int k) {
//         int n = nums.length;
//         Arrays.sort(nums;
//         System.out.println(Arrays.toString(nums));
//         int d = 0, sum = 0;
//         while(sum < k) {
//             d++;
//             sum += n-d;
//         }
//         sum -= (n-d);
//         PriorityQueue<Integer> pq = new PriorityQueue();
//         for(int i = 0, j = i+d ; j < n ; i++,j++) {
//             pq.add(nums[j]-nums[i]);
//         }
//         while(sum < k-1){
//             pq.poll();
//             sum++;
//         }
//         return pq.poll();
//     }
// }
// class Solution { // TLE
//     public int smallestDistancePair(int[] nums, int k) {
//         int n = nums.length;
//         Map<Integer,Integer> countMap = new TreeMap();
//         for(int i = 0 ; i < n ; i++) {
//             for(int j = i+1 ; j < n ; j++) {
//                 int absDiff = Math.abs(nums[i]-nums[j]);
//                 countMap.put(absDiff, countMap.getOrDefault(absDiff,0) + 1);
//             }
//         }
//         for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
//             k -= entry.getValue();
//             if(k <= 0)
//                 return entry.getKey();
//         }
//         return -1;
//     }
// }
// class Solution { // 792ms
//     static int count[] = new int[1000001];
//     public int smallestDistancePair(int[] nums, int k) {
//         int n = nums.length;
//         Arrays.fill(count,0);
//         for(int i = 0 ; i < n ; i++) {
//             for(int j = i+1 ; j < n ; j++) {
//                 count[Math.abs(nums[i]-nums[j])]++;
//             }
//         }
//         int i = 0;
//         while(k > 0) {
//            k -= count[i++]; 
//         }
//         return i-1;
//     }
// }
/*
[1,3,1]
1
[1,1,1]
2
[1,6,1]
3
[62,100,4]
2
[9,10,7,10,6,1,5,4,9,8]
18

*/
