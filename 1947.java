// https://leetcode.com/problems/maximum-compatibility-score-sum/

class Solution {
    /*
    Approach 1  : Brute force
    
    We need to find a permutation of mentors that provide best compatibility score
    so total we have m! permutations
    for each permutation we need to calculate compatibility score
    which will take m*n time
    So TC : m!*m*n
    No of operations : 8!*8*8 => 40320*64 => 2580480 => 2.5 * 10^6
    
    Approach 2 : 
    We can apply dp as well
    as we have total m students and m mentors and m <=8 
    so in order to mark visited to a mentors we can use bit of integer
    
    maxScore(int m, int mask) : return max compatability score
    
    mask & (1<<i) == 1 means ith metor is already assigned and 
                     0 means ith mentor is available.
    
    TC : no if unique problems = m*2^m
         to solve 1 problem = m*n
     => O(m*2^m *m*n)
     => 8*2^8*8*8 => 131072 => 1.3 * 10^5
         
    */
    int dp[][] = null;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int rows = students.length, cols = students[0].length;
        dp = new int[rows+1][(1<<rows) + 1];
        for(int i = 0 ; i <= rows ; i++){
            Arrays.fill(dp[i],-1);
        }
        return maxScore(rows,0, students, mentors);
    }
    int maxScore(int rows, int mask, int[][] students, int[][] mentors){
        if(rows == 0)
            return 0;
        if(dp[rows][mask] != -1) return dp[rows][mask];
        int res = 0;
        for(int i = 0 ; i < students.length ; i++){
            if((mask & (1<<i)) == 0){
                int score = 0;
                for(int j = 0 ; j < students[0].length ; j++){
                    if(students[rows-1][j] == mentors[i][j])
                        score++;
                }
                res = Math.max(res, score + maxScore(rows-1, mask | (1<<i), students, mentors));
            }   
        }
        return dp[rows][mask] = res ;
    }
}
/*
[[1,1,0],[1,0,1],[0,0,1]]
[[1,0,0],[0,0,1],[1,1,0]]
[[0,0],[0,0],[0,0]]
[[1,1],[1,1],[1,1]]
*/
