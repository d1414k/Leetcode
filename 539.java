//https://leetcode.com/problems/minimum-time-difference/

class Solution {
    /*
    1. sort it 
    2. we will get min diff in consecutive ones
    */
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, (String a, String b)->{
            String []s1 = a.split(":");
            String []s2 = b.split(":");
            String h1 = s1[0], h2 = s2[0], m1 = s1[1], m2 = s2[1]; 
            if(h1.compareTo(h2) == 0)
                return m1.compareTo(m2);
            return h1.compareTo(h2);
        });
        timePoints.add(timePoints.get(0));
        int n = timePoints.size(), minDiff = Integer.MAX_VALUE;
        for(int i = 0 ; i < n-1 ; i++){
            String []s1 = timePoints.get(i).split(":");
            String []s2 = timePoints.get(i+1).split(":");
            int h1 = Integer.parseInt(s1[0]), h2 = Integer.parseInt(s2[0]), m1 = Integer.parseInt(s1[1]), m2 = Integer.parseInt(s2[1]);
            int diff = 0;
            if(i == n-2) {
               diff = h2*60 + m2 + 24*60 - h1*60 - m1; // add 24*60 to get correct diff
            }
            else{
                diff = h2*60 + m2 - h1*60 - m1;    
            }
            minDiff = Math.min(minDiff,diff);
        }
        return minDiff;
    }
}
