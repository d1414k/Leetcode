// https://leetcode.com/problems/palindrome-partitioning/
class Solution {
    boolean [][]dp = null;
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        int n = s.length();
        dp = new boolean[n][n];
        for(int i = 0 ; i < n ; i++){
            dp[i][i] = true;
        }
        for(int i = 0 ; i < n-1 ; i++){
            if(s.charAt(i) == s.charAt(i+1))
                dp[i][i+1] = true;
        }
        for(int l = 3 ; l <= n ; l++){
            for(int i = 0 ; i + l <= n ; i++){
                int j = i + (l-1);
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
            }
        }
        helper(res,s,0,new ArrayList());
        return res;
    }
    void helper(List<List<String>> res, String s, int index, ArrayList<String> cur){
        if(index == s.length()){
            res.add(new ArrayList(cur));
            return;
        }
        int n = s.length();
        for(int i = index ; i < n ; i++){
            if(dp[index][i]){
                cur.add(s.substring(index,i+1));
                helper(res,s,i+1,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
}
