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
