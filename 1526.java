// https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
class Solution {
    /*
    -Just think in reverse order 
    -what will be our last operation
    -I used non decreasing stack here
    TC : O(n)
    SC : O(n)
    */
    // public int minNumberOperations(int[] target) {
    //     int ans = 0;
    //     Deque<Integer> stack = new ArrayDeque(); // non-decreasing stack
    //     for(int cur : target) {
    //         while(!stack.isEmpty() && stack.peek() > cur) {
    //             int top = stack.pop();
    //             if(stack.isEmpty()) {
    //                 ans += top - cur;
    //             }else{
    //                 ans += top - Math.max(stack.peek(), cur);
    //             }
    //         }
    //         stack.push(cur);
    //     }
    //     while(!stack.isEmpty()) {
    //         int top = stack.pop();
    //         if(stack.isEmpty()) {
    //             ans += top;
    //         }else{
    //             ans += top - stack.peek();
    //         }
    //     }
    //     return ans;
    // }
    /*
    -we know that at least we need max element #opetaions
    -if we reach to element a[k] then all the elements <= a[k]
    to its left or right will also be covered
    
    TC : O(n)
    SC : O(1)
    */
    public int minNumberOperations(int[] target) {
        int ans = target[0];
        for(int i = 1 ; i < target.length ; i++) {
            if(target[i] > target[i-1])
                ans += target[i] - target[i-1];
        }
        return ans;
    }
}
