// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

class Solution {
    int []temp;
    public int minMoves2(int[] nums) {
        int n = nums.length, res = 0;
        temp = new int[n];
        int median = findKthElement(nums, 0, nums.length-1, n/2);
        for(int i = 0 ; i < n; i++) {
            res += Math.abs(nums[i] - median);
        }
        return res;
    }
    
    // use quickselect algorithms
    int findKthElement(int []nums, int l, int h, int k) {
        if (l == h) return nums[l];
        
        int index = partition(nums,l, h);
        if(index == k)
            return nums[k];
        if (index < k) 
            return findKthElement(nums, index+1, h, k);
        return findKthElement(nums, l, index-1, k);
    }
    
    int partition(int []nums, int l, int h) {
        int pivot = medianOfMedian(nums, l, h);
        for(int j = l ; j <= h ; j++) {
            if(nums[j] == pivot){
                swap(nums, j, h);
                break;
            }
        }
        int i = l-1;
        for(int j = l ; j < h ;j++) {
            if(nums[j] <= pivot){
                swap(nums,++i, j);
            }
        }
        swap(nums,++i, h);
        return i;
    }
    void swap(int []nums, int i, int j) {
        int x = nums[i];
        nums[i] = nums[j];
        nums[j] = x;
    }
    
    int medianOfMedian(int []nums, int l, int h) {
       if(l == h)
           return nums[l];
        int n = (h-l+1+4)/5;
        int []median = temp;
        for(int i = 0 ; i < n ; i++) {
            median[i] = findMedian(nums, l+5*i, l+5*i+4 > h ? h : l+5*i+4);
        }
        return medianOfMedian(median, 0, n-1);
    }
    
    int findMedian(int []a, int l, int h){
        Arrays.sort(a, l, h+1);
        return a[(l+h)/2];
    }
}
