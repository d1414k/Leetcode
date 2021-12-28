// https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
class Solution {
    /*
    -Just think in reverse order 
    -what will be our last operation
    -I used non decreasing stack here
    TC : O(n)
    SC : O(n)
    */
    public int minNumberOperations(int[] target) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque(); // non-decreasing stack
        for(int cur : target) {
            while(!stack.isEmpty() && stack.peek() > cur) {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    ans += top - cur;
                }else{
                    ans += top - Math.max(stack.peek(), cur);
                }
            }
            stack.push(cur);
        }
        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(stack.isEmpty()) {
                ans += top;
            }else{
                ans += top - stack.peek();
            }
        }
        return ans;
    }
}
