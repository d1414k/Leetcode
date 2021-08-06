// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        HashSet<Character>  hs = new HashSet();
        int i = 0, n = s.length(), maxLen = 1;
        hs.add(s.charAt(i));//[c,a,b]
        for(int j = 1; j < n ; j++){
            char ch = s.charAt(j);
            while(hs.contains(ch)){
                hs.remove(s.charAt(i++));    
            }
            hs.add(ch);
            maxLen = Math.max(maxLen,j-i+1);
        }
        return maxLen;
    }
}
/*
abcabcbb
*/
