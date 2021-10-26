// https://leetcode.com/problems/minimum-sideway-jumps/

class Solution {
    /*
    Here we have can travsere from right to left
    if there is obstacle in (i+1) index on same lane 
    we need to change lane else not
    we can use dp here
    
    TC : 0(n)
    SC : 0(1)
    */
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int []dp = new int[4]; // min jump need for each lane to reach end
        for(int i = n-2 ; i >= 0 ; i--){
             for(int lane = 1 ; lane <= 3 ; lane++) {
                 if(obstacles[i+1] == lane){
                     int min = Integer.MAX_VALUE;
                     for(int nextLane = 1 ; nextLane <= 3 ; nextLane++) {
                        if(nextLane != obstacles[i] && nextLane != lane)
                            min = Math.min(min, dp[nextLane]); 
                    }
                    dp[lane] = min + 1;
                 }
             }  
        }
        return dp[2];
    }
}

// class Solution {
//     public int minSideJumps(int[] obstacles) {
//         int n = obstacles.length;
//         int [][]dp = new int[n][4];
//         for(int i = n-2 ; i >= 0 ; i--){
//              for(int lane = 1 ; lane <= 3 ; lane++) {
//                  if(obstacles[i+1] != lane)
//                     dp[i][lane] = dp[i+1][lane];
//                  else{
//                      int min = Integer.MAX_VALUE;
//                      for(int nextLane = 1 ; nextLane <= 3 ; nextLane++) {
//                         if(nextLane != obstacles[i] && nextLane != lane)
//                             min = Math.min(min, dp[i+1][nextLane]); 
//                     }
//                     dp[i][lane] = min + 1;
//                  }
//              }  
//         }
//         return dp[0][2];
//     }
// }

// class Solution {
//     int [][]dp;
//     public int minSideJumps(int[] obstacles) {
//         int n = obstacles.length;
//         dp = new int[n][4];
//         for(int i = 0 ; i < n ; i++)
//             Arrays.fill(dp[i], -1);
//         return helper(obstacles,0,2);
//     }
    
//     int helper(int []obstacles, int index, int lane) { //System.out.println(index+" "+lane);
//         // base case
//         if(index == obstacles.length-1)
//             return 0;
//         if(dp[index][lane] != -1) 
//             return dp[index][lane];                                            
//         if(obstacles[index+1] != lane)
//             return helper(obstacles, index + 1, lane);
//         int min = Integer.MAX_VALUE;
//         for(int i = 1 ; i <= 3 ; i++) {
//             if(i != obstacles[index] && i != lane)
//                 min = Math.min(min, helper(obstacles, index + 1, i)); 
//         }
//         return dp[index][lane] = min + 1; // need a jump here
//     }
// }
