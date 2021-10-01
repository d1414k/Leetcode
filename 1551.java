// https://leetcode.com/problems/minimum-operations-to-make-array-equal/

class Solution {
    public int minOperations(int n) {
        if(n <= 1) return 0;
        int m = (n >> 1); // no of elements that we need to modify
        //even  :   .......7 5 3 1  => m*m
        //odd :   .......8 6 4 2  => m(m+1)
        if((n&1) != 0)
            return m*(m+1);
        return m*m;
    }
}

// class Solution {
//     public int minOperations(int n) {
//         // (2*(midIndex-1) + 1 + 2*midIndex + 1) >> 1 = 2*midIndex
//         int midIndex = n>>1, desiredNum =
//             (n & 1) == 0 ?  midIndex<<1 : (midIndex<<1) + 1 , res = 0;
//         for(int i = 0 ; i < midIndex  ; i++) {
//             res += desiredNum - ((i<<1)+1);
//         }
//         return res;
//     }
// }
