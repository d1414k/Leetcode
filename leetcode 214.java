// https://leetcode.com/problems/shortest-palindrome/
// https://www.youtube.com/watch?v=c4akpqTwE5g
class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder p = new StringBuilder(s); //pp(p.toString());
        StringBuilder rev = new StringBuilder(s).reverse(); //pp(rev.toString());
        p.append("$").append(rev);//pp(p.toString());
        int n = p.length();
        int []lps = new int[n];
        int i = 0;
        for(int j = 1 ; j < n ;){
            if(p.charAt(i) == p.charAt(j)){
                lps[j] = i + 1;
                i++;
                j++;
            }else{
                if(i > 0){
                    i = lps[i-1];
                }
                else{
                    j++;
                }
            }
        }//pp(""+Arrays.toString(lps));
        // abad$daba => need to remove aba
        return rev.substring(0,rev.length()-lps[n-1]) + s;
    }
    void pp(String s){
        System.out.println(s);
    }
}
/*
"aacecaaa"

aacecaaa$aaacecaa
01

*/
