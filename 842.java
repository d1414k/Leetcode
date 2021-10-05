// https://leetcode.com/problems/split-array-into-fibonacci-sequence/

class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList();
        if(helper(res,num.toCharArray(),0))
            return res;
        return new ArrayList();
    }
    boolean helper(List<Integer> res, char []s, int index) {
        if(index == s.length) 
            return res.size() > 2;
        long num = 0;
        for(int i = index ; i < s.length ; i++) {
            num = 10*num + s[i] - '0';
            if((i > index && s[index] == '0') || num > Integer.MAX_VALUE) return false;
            
            if(res.size() < 2 || res.get(res.size()-1) + res.get(res.size()-2) == num) {
                res.add((int)num);
                if(helper(res,s,i+1)) 
                    return true;
                res.remove(res.size()-1);
            }
            else if(res.get(res.size()-1) + res.get(res.size()-2) < num)
                return false;
        }
        return false;
    }
}
// class Solution {
//     int [][]dp = null;
//     public List<Integer> splitIntoFibonacci(String num) {
//         List<Integer> res = new ArrayList<Integer>();
//         char s[] = num.toCharArray();
//         int n = s.length;
//         if(n < 3) 
//             return res;
//         dp = new int[n][n];
//         for(int i = 0 ; i < n ; i++){
//             dp[i][i] = s[i] - '0';
//         }
//         for(int i = 0 ; i < n ; i++){
//             for(int j = i+1 ; j < n ; j++) {
//                 dp[i][j] = 10*dp[i][j-1] + s[j] - '0';
//             }
//         }
//         for(int i = 0 ; i <= n-3 ; i++) {
//             if(i > 0 && s[0] == '0') return res;
//             for(int j = i+1 ; j <= n-2 ; j++) {
//                 if(j > i+1 && s[i+1] == '0') continue;
//                 int num1 = dp[0][i];
//                 int num2 = dp[i+1][j];
//                 if(helper(res,s,j+1, num1,num2)) { 
//                     res.add(num2);
//                     res.add(num1);
//                     Collections.reverse(res);
//                     return res;
//                 }
//             }
//         }
//         return res;
//     }
    
//     boolean helper(List<Integer> res, char []s, int index, int num1, int num2) {
//         if(index == s.length)
//             return true;
//         int num3 = num1 + num2;
//         int length = getLength(num3); //System.out.println(length+" "+index);
//         if(index + length > s.length || (length > 1 && s[index] == '0')) return false;
    
//         if(num3 == dp[index][index+length-1] && helper(res,s,index + length,num2,num3)){
//             res.add(num3);
//             return true;
//         }
//         return false;
//     } 
//     int getLength(int num) {
//         if(num == 0) return 1;
//         int len = 0;
//         while(num > 0 ){
//             len++;
//             num /= 10;
//         }
//         return len;
//     }
// }
/*
"123456579"
"11235813"
"112358130"
"0123"
"1101111"
"0000"
*/
