//https://leetcode.com/problems/next-greater-element-ii/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // we can use stack here
        // to handle circular property we traverse 2 times
        // first time will just update stack
        // second time we actually update res array
        int n = nums.length;
        int []res = new int[n];
        Stack<Integer> stack = new Stack();
        // first time
        for(int i = n-1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            stack.push(nums[i]);
        }
        // second time
        for(int i = n-1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            if(stack.isEmpty())
                res[i] = -1;
            else
                res[i] = stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
