// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
class Solution {
    public static final int MAX = 1000001;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][]a = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            Arrays.fill(a[i],MAX);
        }
        for(int []e : edges) {
            int u = e[0], v = e[1], w = e[2];
            a[u][v] = w;
            a[v][u] = w;
        }
        for(int i = 0 ; i < n ; i++) {
            a[i][i] = 0;
        }
        for(int k = 0 ; k < n ; k++){
           for(int i = 0 ; i < n ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    a[i][j] = Math.min(a[i][j], a[i][k]+a[k][j]);
                }
            } 
        }
        int minCount = n+1, minIndex = -1;
        for(int i = 0 ; i < n ; i++) {
            int count = 0;
            for(int j = 0 ; j < n ; j++) {
                if(i != j && a[i][j] <= distanceThreshold)
                    count++;
            }
            if(count <= minCount) {
                minCount = count;
                minIndex = i;
            }
        } 
        return minIndex;
    }
}
