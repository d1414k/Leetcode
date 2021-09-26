// https://leetcode.com/problems/sort-characters-by-frequency/
class Solution {
    public String frequencySort(String s) {
        int n = s.length(), c[][] = new int[128][2];
        for(int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            c[ch][0] = ch;
            c[ch][1]++;
        }
        Arrays.sort(c,(int []a, int []b) -> b[1]-a[1]);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 128 ; i++) {
            while(c[i][1] > 0){
                sb.append((char)c[i][0]); 
                c[i][1]--;
            }
        }
        return sb.toString();
    }
}
