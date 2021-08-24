// https://leetcode.com/problems/sum-of-subarray-minimums/

class Solution {
    /*
    We will find left and right boundary for each no
    boundary means until that points all no are greater than current
    we can use stack (increasing) to find out boundary index
    TC : O(n) 
    SC : O(n)   : used for stack and left boundary
    */
    public static final int mod = 1000000007;
    // Approach 1
    
//     public int sumSubarrayMins(int[] a) {
//         int n = a.length;
//         Stack<Integer> stack = new Stack<Integer>();// it holds index
//         int []left = new int[n];
//         for(int i = 0 ; i < n ; i++){
//             while(!stack.isEmpty() && a[stack.peek()] >= a[i])
//                 stack.pop();
//             if(stack.isEmpty())
//                 left[i] = -1;
//             else
//                 left[i] = stack.peek();
//             stack.push(i);
//         }//System.out.println(""+Arrays.toString(left));
//         long res = 0,curRight = 0;
//         stack = new Stack<Integer>();
//         for(int i = n-1 ; i >= 0 ; i--){
//             while(!stack.isEmpty() && a[stack.peek()] > a[i])
//                 stack.pop();
//             if(stack.isEmpty())
//                 curRight = n;
//             else
//                 curRight = stack.peek();
//             stack.push(i); //System.out.println(curRight);
//             // Now calculate res
//             res =  (res + (a[i]*((i - left[i]) * (curRight - i)))%mod)%mod;
//             //System.out.println("res " + res);
//         }
        
//         return (int)res;
//     }
    
    // Approach 2
    public int sumSubarrayMins(int[] a) {
        int n = a.length;
        Stack<Integer> stack = new Stack<Integer>();// it holds index
        int []left = new int[n];
        int []right = new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right,n);
        long res = 0;
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && a[stack.peek()] > a[i])
                right[stack.pop()] = i;
            if(!stack.isEmpty())
                left[i] = stack.peek();
            stack.push(i);
            
        }//System.out.println(""+Arrays.toString(left));
        // Now calculate res
        for(int i = 0 ; i < n ; i++){
            res =  (res + ((long)a[i]*((i - left[i]) * (right[i] - i)))%mod)%mod;
        }
        return (int)res;
    }
}

/*
[3,1,2,4]
1 => 6
2 => 2
3 => 1
4 => 1
[3,1,2,4]
[11,81,94,43,3]
[71,55,82,55]
*/
