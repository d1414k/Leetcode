// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, sum = 0, maxSum = 0;
        // first window
        for(int i = 0 ; i < k ; i++){
            sum += cardPoints[i];
        }
        maxSum = sum;
        // so for we have [0,k-1] window sum
        // and try to add one one element from n-1 and remove fron k-1 side
        for(int i = k-1, j = n-1 ; i >= 0 ; i--,j--){
            sum += cardPoints[j] - cardPoints[i];
            if(sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }
}
// class Solution {
//     public int maxScore(int[] cardPoints, int k) {
//         int total = 0, n = cardPoints.length, remainging = n - k,sum = 0,minSum = Integer.MAX_VALUE;
//         // Need find subarray of length "raminaing" with min sum
//         for(int i = 0 ; i < remainging ; i++){
//             sum += cardPoints[i];
//         }
//         total = sum;
//         minSum = sum;
//         for(int i = remainging ; i < n ; i++){
//             sum -= cardPoints[i-remainging];
//             sum += cardPoints[i];
//             total += cardPoints[i];
//             if(sum < minSum)
//                 minSum = sum;
//         }
//         return total - minSum;
//     }
// }
/*
[1,2,3,4,5,6,1]
3
[2,2,2]
2
[9,7,7,9,7,7,9]
7
[1,1000,1]
1
[1,79,80,1,1,1,200,1]
3
[100,40,17,9,73,75]
3
*/
