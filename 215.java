// https://leetcode.com/problems/kth-largest-element-in-an-array/

/*
Create empty min heap of size k
keep on adding elements until no of elements are < k
now for each new no comapre with root of heap
if new element is smaller than root ignore it 
otherwise delete root and add this new element.
*/
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         if(nums == null || nums.length == 0)
//             return -1;
//         PriorityQueue<Integer> q = new PriorityQueue(k);
//         for(int i = 0 ; i < nums.length ; i++){
//             if(q.size() < k)
//                 q.add(nums[i]);
//             else{
//                 if(q.peek() < nums[i]){
//                     q.poll();
//                     q.add(nums[i]);
//                 }
//             }//System.out.println(q);
//         }
//         return q.peek();
//     }
// }
//https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained
// Approach similar to quick sort : might be O(n^2) in worst case and O(n) in average case
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         if(nums == null || nums.length == 0)
//             return -1;
//         return find(nums,0,nums.length - 1 ,k);
//     }
//     int find(int []nums, int l, int h, int k){
//         if(l > h)
//             return -1;
//         int mid = partition(nums,l,h);
//         if(mid == k - 1)
//             return nums[mid];
//         if(mid > k - 1)// go left
//             return find(nums,l,mid - 1,k);
//         return find(nums,mid + 1,h,k);
//     }
//     int partition(int nums[], int l,int h){
//         int pivot = nums[h];
//         int i = l - 1;
//         for(int j = l ; j <= h - 1 ; j++){
//             if(nums[j] > pivot){
//                 i++;
//                 swap(nums,i,j);
//             }
//         }
//         swap(nums,i+1,h);
//         return i + 1;
//     }
//     void swap(int []nums,int x, int y){
//         int t = nums[x];
//         nums[x] = nums[y];
//         nums[y] = t;
//     }
// }
// suffle the input first to make average case even if worst case input is given
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         if(nums == null || nums.length == 0)
//             return -1;
//         suffle(nums);
//         return find(nums,0,nums.length - 1 ,k);
//     }
//     void suffle(int []nums){
//         Random r = new Random();
//         for(int i = 1 ; i < nums.length ; i++){
//             swap(nums,i,r.nextInt(i + 1));
//         }
//     }
//     int find(int []nums, int l, int h, int k){
//         if(l > h)
//             return -1;
//         int mid = partition(nums,l,h);
//         if(mid == k - 1)
//             return nums[mid];
//         if(mid > k - 1)// go left
//             return find(nums,l,mid - 1,k);
//         return find(nums,mid + 1,h,k);
//     }
//     int partition(int nums[], int l,int h){
//         int pivot = nums[h];
//         int i = l - 1;
//         for(int j = l ; j <= h - 1 ; j++){
//             if(nums[j] > pivot){
//                 i++;
//                 swap(nums,i,j);
//             }
//         }
//         swap(nums,i+1,h);
//         return i + 1;
//     }
//     void swap(int []nums,int x, int y){
//         int t = nums[x];
//         nums[x] = nums[y];
//         nums[y] = t;
//     }
// }
// using median of median as pivot element O(n) 
class Solution {
    int []temp  = null;
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return -1;
        temp = new int[nums.length];
        return find(nums,0,nums.length - 1 ,k);
    }
    int find(int []nums, int l, int h, int k){
        if(l > h)
            return -1;
        int mid = partition(nums,l,h);
        if(mid == k - 1)
            return nums[mid];
        if(mid > k - 1)// go left
            return find(nums,l,mid - 1,k);
        return find(nums,mid + 1,h,k);
    }
    int partition(int nums[], int l,int h){
        int pivot = medianOfMedian(nums,l,h);
        int j = l;// search pivot elemnt
        for(; j < h ; j++){
            if(nums[j] == pivot)
                break;
        }
        swap(nums,j,h);// swap with end
        int i = l - 1;
        for(j = l ; j <= h ; j++){
            if(nums[j] > nums[h]){
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,h);
        return i + 1;
    }
    void swap(int []nums,int x, int y){
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
    int medianOfMedian(int []nums, int l,int h){
        if(l==h)
            return nums[l];
        int n = (h - l + 1 + 4) / 5;// + 4 to handle both cases of divisible by 5 or not divisibe by 5
        int []median = temp;// use temporary array instead of creating new array
        for(int i = 0 ; i < n ; i++){
            median[i] = findMedian(nums,l + 5*i,(l + 5*i + 4) <= h ? (l + 5*i + 4) : h);
        }
        return medianOfMedian(median,0,n-1);
    }
    int findMedian(int []nums,int l,int h){
        Arrays.sort(nums,l,h+1);
        return nums[l + (h - l)/2];
    }
}
/*
[3,2,1,5,6,4]
2
[3,2,3,1,2,4,5,5,6]
4
*/
