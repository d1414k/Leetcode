// https://leetcode.com/problems/lexicographical-numbers/

// Approach 1 :  using loop as we can have max 5 digits
// class Solution {
//     public List<Integer> lexicalOrder(int n) {
//         List<Integer> res = new ArrayList();
//         for(int first = 1 ; first <= 9; first++) {
//             int a = first;
//             if(a > n)
//                 break;
//             res.add(a);
//             for(int second = 0 ; second <= 9; second++) {
//                 int b = 10*a + second;
//                 if(b > n)
//                     break;
//                 res.add(b);
//                 for(int third = 0 ; third <= 9; third++) {
//                     int c = 10*b + third;
//                     if(c > n)
//                         break;
//                     res.add(c);
//                     for(int forth = 0 ; forth <= 9; forth++) {
//                         int d = 10*c + forth;
//                         if(d > n)
//                             break;
//                         res.add(d);
//                         for(int fifth = 0 ; fifth <= 9; fifth++) {
//                             int e = 10*d + fifth;
//                             if(e > n)
//                                 break;
//                             res.add(e);
//                         }
//                     }        
//                 }
//             }
//         }
//         return res;
//     }
// }
// Approach : using dfs
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList();
        for(int i = 1 ; i < 10 ; i++) {
            helper(res, i, n);
        }
        return res;
    }
    void helper(List<Integer> res, int cur, int n) {
        if(cur > n) return;
        res.add(cur);
        for(int i = 0 ; i < 10; i++) {
            helper(res, 10*cur + i, n);
        }
    }
}



