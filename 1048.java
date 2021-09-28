// https://leetcode.com/problems/longest-string-chain/
class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length, dp[] = new int[n], res = 1;
        Arrays.fill(dp,1);
        Arrays.sort(words, (String a, String b) -> a.length() - b.length());        
        for(int i = 1 ; i < n ; i++) {
           for(int j = 0 ; j < i ; j++) {
               if(isPredecesor(words[j], words[i])) {
                   dp[i] = Math.max(dp[i], 1 + dp[j]);
               }
            } 
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    boolean isPredecesor(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(n != m - 1) return false;
        int i = 0, j = 0;
        for(; i < n && j < m ; j++) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            if(j-i > 1)
                return false;
        }
        return i < n ? false : true;
    }
}
