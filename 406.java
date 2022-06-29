// https://leetcode.com/problems/queue-reconstruction-by-height/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (int []a, int []b)->{
           if(a[0] == b[0]) // heights equal
               return a[1]-b[1];
            return b[0]-a[0];// decreasing order
        });
        List<int[]> res = new ArrayList();
        for(int []p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][2]);
    }
}
