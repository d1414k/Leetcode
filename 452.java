// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

class Solution {
    /*
    sort based on start index
    if two intervals overlap then update first interval as common one
    
    TC: O(nlogn)
    SC: O(1)
    */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (int []a, int []b)-> Integer.compare(a[0],b[0]));
        int n = points.length, index = 0;
        for(int i = 1 ; i < n ; i++) {
            int []last = points[index];
            // check if overlap
            if(points[i][0] <= last[1]) {
                last[0] =  points[i][0];
                last[1] = Math.min(last[1], points[i][1]);
            }
            else{
                index++;
                points[index] = points[i];
            }
        }
        return index + 1;
    }
    // public int findMinArrowShots(int[][] points) {
    //     Arrays.sort(points, (int []a, int []b)-> a[0]-b[0]);
    //     List<int[]> list = new ArrayList();
    //     int n = points.length;
    //     list.add(points[0]);
    //     for(int i = 1 ; i < n ; i++) {
    //         int []last = list.get(list.size() - 1);
    //         // check if overlap
    //         if(last[0] <= points[i][0] && points[i][0] <= last[1]) {
    //             last[0] =  points[i][0];
    //             last[1] = Math.min(last[1], points[i][1]);
    //         }
    //         else{
    //             list.add(points[i]);
    //         }
    //     }
    //     return list.size();
    // }
}
