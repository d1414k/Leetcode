//https://leetcode.com/problems/max-value-of-equation/

class Solution {
    /*
    yi + yj + |xi - xj|
    
    if we take point in order like i < j and its given that xi < xj
    then this formula will be 
    = yi + yj + xj - xi
    = (yi - xi) + (yj + xj)
    
    lets take j as current Index
    
    so if we know max value of (yi - xi) we can calculate res using current Index
    we can use maxHeap to find max value of this
    
    TC : O(nlogn)
    */
    // Appraoch 1
    // public int findMaxValueOfEquation(int[][] points, int k) {
    //     // int[] => Its an array of 2 elements [yi-xi,xi]
    //     PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->y[0]-x[0]);
    //     pq.add(new int[]{points[0][1]-points[0][0],points[0][0]});
    //     int res = Integer.MIN_VALUE;
    //     for(int j = 1 ; j < points.length ; j++){
    //         while(!pq.isEmpty() && points[j][0] - pq.peek()[1] > k)
    //             pq.poll();
    //         if(!pq.isEmpty()){
    //             res = Math.max(res, pq.peek()[0] + points[j][1] + points[j][0]);
    //         }
    //         pq.add(new int[]{points[j][1] - points[j][0],points[j][0]});
    //     }
    //     return res;
    // }
    
    // Appraoch 2
    public int findMaxValueOfEquation(int[][] points, int k) {
        // pq will be sorted based on yi-xi
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1,p2)->(p2[1]-p2[0]) - (p1[1]-p1[0]));
        pq.offer(points[0]);
        int res = Integer.MIN_VALUE;
        for(int j = 1 ; j < points.length ; j++){
            while(!pq.isEmpty() && points[j][0] - pq.peek()[0] > k)
                pq.poll();
            if(!pq.isEmpty()){
                res = Math.max(res, pq.peek()[1] - pq.peek()[0]  + points[j][1] + points[j][0]);
            }
            pq.offer(points[j]);
        }
        return res;
    }
}
/*
[[1,3],[2,0],[5,10],[6,-10]]
1
[[0,0],[3,0],[9,2]]
3
[[-19,-12],[-13,-18],[-12,18],[-11,-8],[-8,2],[-7,12],[-5,16],[-3,9],[1,-7],[5,-4],[6,-20],[10,4],[16,4],[19,-9],[20,19]]
6
*/
