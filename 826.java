// https://leetcode.com/problems/most-profit-assigning-work/

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int [][]t = new int[n][2];
        
        for(int i = 0 ; i < n ; i++) {
            t[i][0] = difficulty[i];
            t[i][1] = profit[i];
        }
        
        Arrays.sort(t, (int []x, int []y)-> x[0]-y[0]);
        Arrays.sort(worker);
        
        // update max profit from 0 to i
        for(int i = 1 ; i < n ; i++) {
            t[i][1] = Math.max(t[i][1], t[i-1][1]);
        }
        
        int i = 0, j = 0, res = 0;
        while(j < worker.length) {
            for(; i < n && t[i][0] <= worker[j] ; i++);
            if (i > 0) {
                res += t[i-1][1];
            }
            j++;
        }
        return res;
    }
}
/*
[2,4,6,8,10]
[10,20,30,40,50]
[4,5,6,7]
[85,47,57]
[24,66,99]
[40,25,25]
[68,35,52,47,86]
[67,17,1,81,3]
[92,10,85,84,82]
*/
