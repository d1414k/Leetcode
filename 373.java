// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

class Solution {
    /*
    https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
    We know that each num1 will get min sum if paired with nums2[0]
    */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k,
        (int[]a,int[]b)->nums1[a[0]]+nums2[a[1]] - (nums1[b[0]]+nums2[b[1]]));
        for(int i = 0 ; i < nums1.length && i < k ; i++) {
            pq.add(new int[]{i,0});
        }
        List<List<Integer>> res = new ArrayList();
        while(k-- > 0 && !pq.isEmpty()) {
            int []a = pq.poll();
            res.add(Arrays.asList(new Integer[]{nums1[a[0]], nums2[a[1]]}));
            a[1]++;
            if(a[1] < nums2.length){
                pq.add(a);
            }
        }
        return res;
    }
}
// class Solution { // wrong
//     // we can see that k < n*m
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//         int n = nums1.length, m = nums2.length, i = 0, j = 0;
//         Boolean flag = null;
//         while(i < n && j < m) {System.out.println(i+" "+j);
//             if(nums1[i] < nums2[j]) {
//                 i++;
//                 if(flag == null)
//                     flag = false; // tie break as second array
//             }
//             else if(nums1[i] > nums2[j]){
//                 j++;
//                 if(flag == null)
//                     flag = true;
//             }
//             else {
//                 if(flag == null || flag)
//                     i++;
//                 else
//                     j++;
                
//             }
//             if(i*j >= k)
//                 break;
//         }
//         while(i < n && i*j < k )
//             i++;
//          while(j < m && i*j < k )
//             j++;
//         System.out.println(i+" "+j);
//         n = i;
//         m = j;
//         List<List<Integer>> res = new ArrayList();
//         for(i = 0 ; i < n ; i++) {
//             for(j = 0 ; j < m ; j++) {
//                 res.add(Arrays.asList(new Integer[]{nums1[i],nums2[j]}));
//             }
//         }
//         Collections.sort(res,
//                          (List<Integer>a, List<Integer> b) -> (a.get(0)+a.get(1)) - (b.get(0)+b.get(1)));
//         return res;
//     }
// }
// class Solution {// wrong ans for following
//     /*
//     Your input
//     [1,7,11,15,16,16,17,20,26]
//     [2,4,6,6,7,9,15]
//     8
//     Output
//     [[1,2],[1,4],[1,6],[1,6],[1,7],[7,2],[1,9],[11,2]]
//     Diff
//     Expected
//     [[1,2],[1,4],[1,6],[1,6],[1,7],[7,2],[1,9],[7,4]]
//     */
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//         List<List<Integer>> res = new ArrayList();
//         res.add(Arrays.asList(new Integer[]{nums1[0], nums2[0]}));
//         k--;
//         int low1 = 0,low2 = 0, high1 = 1, high2 = 1, n = nums1.length, m = nums2.length;
//         while(k > 0 && low1 < n && high1 < n && low2 < m && high2 < m) {
//             if(nums1[low1] + nums2[high2] < nums2[low2] + nums1[high1]){
//                 res.add(Arrays.asList(new Integer[]{nums1[low1], nums2[high2]}));
//                 high2++;
//                 if(high2 == m){
//                     low1++;
//                     high2 = low1; 
//                 }
//             }
//             else{
//                 res.add(Arrays.asList(new Integer[]{nums1[high1],nums2[low2]}));
//                 high1++;
//                 if(high1 == n){
//                     low2++;
//                     high1 = low2; 
//                 }
//             }
//             k--;
//         }
//         while(k > 0 && low1 < n && high2 < m) {
//             res.add(Arrays.asList(new Integer[]{nums1[low1], nums2[high2]}));
//             high2++;
//             if(high2 == m){
//                 low1++;
//                 high2 = low1; 
//             }
//         }
//         while(k > 0 && low2 < m && high1 < n) {
//             res.add(Arrays.asList(new Integer[]{nums1[high1],nums2[low2]}));
//             high1++;
//             if(high1 == n){
//                 low2++;
//                 high1 = low2; 
//             }
//         }
//         return res;
//     }
// }
