// https://leetcode.com/problems/check-if-a-string-can-break-another-string/

class Solution {
    /*
    we can create two count array corresponding to each string s1 and s2
    if(c1[i] < c2[i]) 
        s1BreakS2 = false;
    // means there exist a char in s2 for which this no char in s1 such that it satisfy >= (breaking) condition
    TC : O(n)
    SC : O(1)
    */
    public boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();
        int []c1 = new int[26];
        int []c2 = new int[26];
        for(int i = 0 ; i < n ; i++){
            c1[s1.charAt(i)-'a']++;
            c2[s2.charAt(i)-'a']++;
        }
        boolean s1BreakS2 = true,s2BreakS1 = true;
        for(int i = 0 ; i < 26 ; i++){
            if(i > 0){
                c1[i] += c1[i-1];
                c2[i] += c2[i-1];
            }
            if(c1[i] < c2[i])
                s1BreakS2 = false;
            else if(c1[i] > c2[i])
                s2BreakS1 = false;
        }
        return s1BreakS2 | s2BreakS1;
    }
}
// class Solution {
//     public boolean checkIfCanBreak(String s1, String s2) {
//         int n = s1.length();
//         char []a = new char[n];
//         char []b = new char[n];
//         int []count = new int[26];
//         // sort s1
//         for(int i = 0 ; i < n ; i++){
//             count[s1.charAt(i)-'a']++; 
//         }
//         for(int i = 1 ; i < 26 ; i++){
//             count[i] += count[i-1];
//         }
//         for(int i = 0 ; i < n ; i++){
//             a[--count[s1.charAt(i)-'a']] =  s1.charAt(i);
//         }
//         // sort s2
//         Arrays.fill(count,0);
//         for(int i = 0 ; i < n ; i++){
//             count[s2.charAt(i)-'a']++; 
//         }
//         for(int i = 1 ; i < 26 ; i++){
//             count[i] += count[i-1];
//         }
//         for(int i = 0 ; i < n ; i++){
//             b[--count[s2.charAt(i)-'a']] =  s2.charAt(i);
//         }
        
//         boolean allInSameOrder = true;
//         // a <= b
//         for(int i = 0 ; i < n ; i++){
//             if(a[i] > b[i])
//                 allInSameOrder = false;
//         }
//         if(allInSameOrder) return true;
//         // a >= b
//         for(int i = 0 ; i < n ; i++){
//             if(a[i] < b[i])
//                 return false;
//         }
//         return true;
//     }
// }
/*
"abc"
"xya"
"abe"
"acd"
"leetcodee"
"interview"
"szy"
"cid" 
*/
