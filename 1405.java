// https://leetcode.com/problems/longest-happy-string/
class Solution {
    public static String [][]dp = {{"a","aa"},{"b","bb"},{"c","cc"}};
    public String longestDiverseString(int a, int b, int c) {
        // int[] : <count,char> : char => 0 1 2 
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[]x, int[]y)->y[0]-x[0]);
        if(a > 0) pq.add(new int[]{a,0});
        if(b > 0) pq.add(new int[]{b,1});
        if(c > 0) pq.add(new int[]{c,2});
        StringBuilder sb = new StringBuilder();
        int n = a + b + c;
        while(pq.size() > 1) { 
            int []x = pq.poll();
            int []y = pq.poll();
            if(x[0] > 1) {
                sb.append(dp[x[1]][1]);
                x[0] -= 2;
                n -= 2;
                // check if we can not add double char
                if(x[0] > n - x[0] || y[0] == 1){
                    sb.append(dp[y[1]][0]);
                    y[0]--;
                    n--;
                }
                else{
                    sb.append(dp[y[1]][1]);
                    y[0]-= 2;
                    n-= 2;
                }
            }
            else{
                sb.append(dp[x[1]][0]);
                x[0]--;
                n--;
            }
            if(x[0] > 0) pq.add(x);
            if(y[0] > 0) pq.add(y);
        }
        if(pq.size() == 1){
            int []x = pq.poll();
            sb.append(dp[x[1]][x[0] == 1 ? 0 : 1]);
        }
        return sb.toString();
    }
}
