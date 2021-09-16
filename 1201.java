// https://leetcode.com/problems/ugly-number-iii/
class Solution {
    public int nthUglyNumber(int n, long a, long b, long c) {
        long l = 0, h = 2000000000;
        int res = -1;
        long lcmAB = (a*b)/gcd(a,b);
        long lcmAC = (a*c)/gcd(a,c);
        long lcmBC = (b*c)/gcd(b,c);
        long lcmABC = (lcmAB*c)/gcd(lcmAB,c);
        while(l <= h) {
            long mid = l + (h - l) / 2;
            long index = mid/a + mid/b + mid/c - mid/lcmAB - mid/lcmAC - mid/lcmBC  + mid/lcmABC; 
            //System.out.println(l+" "+ mid +" "+ h+" index : "+index);
            if(index == n && (mid % a == 0 || mid % b == 0 || mid %c == 0)) 
                res = (int)mid;
            if(index < n)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return res;
    }
    long gcd(long a, long b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
}
// class Solution {
//     public int nthUglyNumber(int n, int a, int b, int c) {
//         int min = 0,ans1,ans2,ans3;
//         ans1 = a;
//         ans2 = b;
//         ans3 = c;
//         for(int i = 0 ; i < n; i++) {
//             min = ans1;
//             if(min > ans2)
//                 min = ans2;
//             if(min > ans3)
//                 min = ans3;
//             if(min == ans1) {
//                 ans1 += a;
//             }
//             if(min == ans2) {
//                 ans2 += b;
//             }
//             if(min == ans3) {
//                 ans3 += c;
//             }
//         }
//         return min;
//     }
// }
/*
ax1  ax2 ax3 ...
bx1  bx2 bx3 ...
cx1  cx2 cx3 ...
3
2
3
5
4
2
3
5
5 
2 
11
13
1000000000
2
217983653
336916467
4
2
3
4
7
7
7
7
*/
