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


class Solution {
    // we can process count array in non-increasing order to get empty cell quickly
    public int minDeletions(String s) {
        boolean []map = new boolean[100001];
        int count[] = new int[26], n = s.length();
        for(int i = 0 ; i < n ; i++) {
            count[s.charAt(i)-'a']++;
        }
        Arrays.sort(count);
        int res = 0, index = 0;
        for(int i = 25 ; i >= 0 ; i--) {
            if(count[i] == 0 ) continue;
            
            if(!map[count[i]]) {
                map[count[i]] = true;
                index = count[i] - 1;
            }
            else{
                if(index > 0){
                    map[index] = true;
                    res += count[i] - index;
                    index--;
                }
                else{
                    res += count[i];
                }
                    
            }
        }
        return res;
    }
}
// class Solution {
//     public int minDeletions(String s) {
//         boolean []map = new boolean[100001];
//         int count[] = new int[26], n = s.length();
//         for(int i = 0 ; i < n ; i++) {
//             count[s.charAt(i)-'a']++;
//         }
//         int res = 0;
//         for(int i = 0 ; i < 26 ; i++) {
//             if(count[i] == 0 ) continue;
            
//             if(!map[count[i]]) {
//                 map[count[i]] = true;
//             }
//             else{
//                 int index = count[i]-1;
//                 while(map[index])
//                     index--;
//                 if(index > 0){
//                     map[index] = true;
//                     res += count[i] - index;
//                 }
//                 else
//                     res += count[i];
                    
//             }
//         }
//         return res;
//     }
// }
