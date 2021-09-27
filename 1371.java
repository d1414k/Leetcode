// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
class Solution {
    static int []dp = {1,0,0,0,2,0,0,0,4,0,0,0,0,0,8,0,0,0,0,0,16};
    public int findTheLongestSubstring(String s) {
        int n = s.length(), mask = 0, res = 0;
        char []c = s.toCharArray();
        int map[] = new int[33]; // <mask, first index>
        Arrays.fill(map,-1);    
        for(int i = 0 ; i < n ; i++) {
            char ch = c[i]; 
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                mask ^= dp[ch-'a'];
                if(map[mask] == -1){
                    map[mask] = i;
                }
            }
            if(mask == 0){
                res = i + 1;
            }
            else if( map[mask] != -1) {
                res = Math.max(res, i-map[mask]);
            }
        }
        return res;
    }
}


// class Solution {
//     static int []dp = new int[26];
//     static {
//         dp['a'-'a'] = 1 << ('a' - 'a');
//         dp['e'-'a'] = 1 << ('e' - 'a');
//         dp['i'-'a'] = 1 << ('i' - 'a');
//         dp['o'-'a'] = 1 << ('o' - 'a');
//         dp['u'-'a'] = 1 << ('u' - 'a');
//     }
//     public int findTheLongestSubstring(String s) {
//         int n = s.length(), mask = 0, res = 0;
//         char []c = s.toCharArray();
//         HashMap<Integer,Integer> hm = new HashMap(); // <mask, first index>
//         for(int i = 0 ; i < n ; i++) {
//             char ch = c[i]; 
//             if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
//                 mask ^= dp[ch-'a'];
//                 if(hm.get(mask) == null){
//                     hm.put(mask,i);
//                 }
//             }
//             if(mask == 0){
//                 res = i + 1;
//             }
//             else {
//                 Integer left = hm.get(mask);
//                 if(left != null) {
//                     res = Math.max(res, i-left);
//                 }
//             }
//         }
//         return res;
//     }
// }
/*
"eleetminicoworoep"
"leetcodeisgreat"
"bcbcbc"
"id"
"ixzhsdka"
*/
