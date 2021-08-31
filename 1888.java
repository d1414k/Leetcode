// https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
// https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/discuss/1257289/simulation-%2B-presum-O(n)-time-and-O(n)-space

//https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/discuss/1253874/C%2B%2B-Solution-sliding-window.-O(N)-Time-O(1)-Space
class Solution {
    public int minFlips(String ss) {
        int n = ss.length();
        StringBuilder s = new StringBuilder(ss);
        s.append(ss);
        StringBuilder s1 = new StringBuilder();//01010101010..
        for(int i = 0 ; i < 2*n ; i++){
            if(i%2 == 0){
                s1.append('0');
            }else{
                s1.append('1');
            }
        }
        StringBuilder s2 = new StringBuilder();// 10101010101..
        for(int i = 0 ; i < 2*n ; i++){
            if(i%2 == 0){
                s2.append('1');
            }else{
                s2.append('0');
            }
        }
        int ans1 = 0, ans2 = 0, res = n;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) != s1.charAt(i)) ans1++;   
            if(s.charAt(i) != s2.charAt(i)) ans2++;   
        }
        res = Math.min(res,ans1);
        res = Math.min(res,ans2);
        for(int i = n ; i < 2*n ; i++){
            if(s.charAt(i) != s1.charAt(i)) ans1++;   
            if(s.charAt(i) != s2.charAt(i)) ans2++; 
            // need to substrack also for outside window 
            if(s.charAt(i-n) != s1.charAt(i-n)) ans1--;   
            if(s.charAt(i-n) != s2.charAt(i-n)) ans2--;
            res = Math.min(res,ans1);
            res = Math.min(res,ans2);
        }
        return res;
    }
}

// class Solution { // wrong ans
//     public int minFlips(String s) {
//         int n = s.length();
//         if(n < 2) return n;
//         int res = helper(s);
//         // for(int i = 1 ; i < n ; i++){
//         //     res = Math.min(res,helper(s.substring(i) + s.substring(0,i)));
//         // }
//         return (res = (n % 2 == 0) ? res : res - 1) < 0 ? 0 : res;
//     }
//     int helper(String s){
//         int countEvenPositionO = 0, countEvenPosition1 = 0;
//         int countOddPositionO = 0, countOddPosition1 = 0,n = s.length();
//         // even position
//         for(int i = 0 ; i < n ; i+=2){
//             if(s.charAt(i) == '0'){
//                 countEvenPositionO++;
//             }else{
//                 countEvenPosition1++;
//             }
//         }
//         // odd position
//         for(int i = 1 ; i < n ; i+=2){
//             if(s.charAt(i) == '0'){
//                 countOddPositionO++;
//             }else{
//                 countOddPosition1++;
//             }
//         }
//         return Math.min(countEvenPositionO + countOddPosition1, countOddPositionO + countEvenPosition1);
//     }
// }
/*
"111000"
"010"
"1110"
"11110"
"111101"
"00011"
"00111"
"01111"
"000011"
"0000111"
"01001001101"
*/
