/*
Devide the array for each 0
Ex : 1 -2 3 0 4 5
it means we have to solve two problem :
ans Max(0,[1 - 2 3], [4 5]) 
1. find product of complete array : cp
2. if(cp > 0) return cp
3. else if(cp < 0 )// means there is at least one -ve no in the 
4. // we need to find product on left and right of this -ve no and check if maximum product is better or not
5. // to do so we can traverse array second time and check if 
*/
// class Solution {// all testcases passes
//     public int maxProduct(int[] nums) {
//         //containing at least one number : no need of base case
//         int res = Integer.MIN_VALUE;
//         int cur = 1;
//         int prev = 0;
//         for(int i = 0 ; i < nums.length ; i++){
//             if(nums[i] == 0){
//                 res = Math.max(res,0);
//                 if(i > 0)
//                     res = Math.max(res,solve(nums,prev,i-1,cur));
//                 prev = i + 1;
//                 cur = 1;
//             }
//             else{
//                 cur *= nums[i];
//             }
//         }
//         if(prev < nums.length){
//             res = Math.max(res,solve(nums,prev,nums.length - 1,cur));
//         }
//         return res;
//     }
    
//     int solve(int []nums, int start, int end, int prod){// sovles if no 0 in nums from start to end
//         if(prod > 0)
//             return prod;
//         int cur = 1;
//         int res = Integer.MIN_VALUE;
//         for(int i = start ; i <= end ; i++){
//             if(nums[i] < 0 ){
//                 if(i > start)
//                     res = Math.max(res,cur);// [start , i-1]
//                 if(i < end)
//                     res = Math.max(res,prod/(cur*nums[i]));//[i+1, end]
//             }
//             cur *= nums[i];
//             res = Math.max(res,cur);
//         }
//         return res;
//     }
// }
// https://www.geeksforgeeks.org/maximum-product-subarray/
// class Solution {// fails for input [-2]
//     public int maxProduct(int[] nums) {
//         //containing at least one number : no need of base case
//         int res = 1,maxEndingHere = 1,minEndingHere = 1;
//         boolean flag = false;// it will be true if there is at lease one +ve no
//         for(int i = 0 ; i < nums.length ; i++){
//             if(nums[i] > 0 ){
//                 maxEndingHere *= nums[i];
//                 minEndingHere = min(minEndingHere*nums[i],1);
//                 flag = true;
//             }
//             else if(nums[i] == 0){
//                 maxEndingHere = 1;
//                 minEndingHere = 1; 
//             }
//             else{
//                 int temp = minEndingHere;
//                 minEndingHere = maxEndingHere*nums[i];
//                 maxEndingHere = max(temp*nums[i],1);
//             }
//             res = max(res,maxEndingHere);
//         }
//         if(!flag && res == 1)// all nos are either 0 or -ve and res = 1 (initial 1) 
//             return 0;
//         return res;
//     }
//     int max(int x, int y){
//         return x > y ? x : y;
//     }
//     int min(int x, int y){
//         return x > y ? y : x;
//     }
// }

// from submissions
// first go from left to right then right to left and calculate maximum product
class Solution {
    public int maxProduct(int[] nums) {
        //containing at least one number : no need of base case
        int res = nums[0];
        int cur = 1;
        // left to right
        for(int i = 0 ; i < nums.length ; i++){
            cur = cur*nums[i];
            if(cur > res)
                res = cur;
            if(cur == 0)
                cur = 1;
        }
        //right to left
        cur = 1;
        for(int i = nums.length - 1 ; i >=0 ; i--){
            cur = cur*nums[i];
            if(cur > res)
                res = cur;
            if(cur == 0)
                cur = 1;
        }
        return res;
    }
}
/*
[2,3,-2,4]
[-2,0,-1]
[-2]
*/
