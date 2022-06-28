// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

class Solution {
    public int minDeletions(String s) {
        int []frequency = new int[26];
        for(int i = 0 ; i < s.length() ; i++) {
            frequency[s.charAt(i)-'a']++;
        }
        Arrays.sort(frequency);
        int maxAvailableNo = s.length(), res = 0;
        for(int i = 25 ; i >= 0 && frequency[i] > 0 ; i--) {
            if(frequency[i] > maxAvailableNo) {
                res += frequency[i] - maxAvailableNo;
                if(maxAvailableNo > 0) // Why 0 eg. "bbcebab"
                    maxAvailableNo--;
            }
            else 
                maxAvailableNo = frequency[i] - 1; 
        }
        return res;
    }
}
