// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int []hash = new int[128];// largest index
        int left = -1, n = s.length(), maxLen = 1;
        Arrays.fill(hash,-1); 
        for(int j = 0; j < n ; j++){
            char ch = s.charAt(j);
            if(hash[ch] != -1){
                left = Math.max(left,hash[ch]);
            }
            maxLen = Math.max(maxLen,j-left);    
            hash[ch] = j;
        }
        return maxLen;
    }
}
/*
"abcabcbb"
"pwwkew"
*/
