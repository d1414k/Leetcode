// https://leetcode.com/problems/can-i-win/
// https://leetcode.com/problems/can-i-win/discuss/95277/Java-solution-using-HashMap-with-detailed-explanation
class Solution {
    int []dp;
    int maxChoosableInteger,desiredTotal;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        dp = new int[1<<20];
        this.maxChoosableInteger = maxChoosableInteger;
        this.desiredTotal = desiredTotal;
        if(desiredTotal < 0 || (maxChoosableInteger*(maxChoosableInteger+1))/2 < desiredTotal )
            return false;
        if(desiredTotal <= maxChoosableInteger)
            return true;
        return helper(0,0) == 1 ? true : false;
    }
    // It returns 1 if A wins
    int helper(int mask,int curSum){
        if(curSum >= desiredTotal)
             return -1;
        if(dp[mask] != 0) return dp[mask];
        boolean res = false;//p(curSum+"");
        for(int i = 0 ; i < maxChoosableInteger ; i++){// for A
            // i can choose this no and opponent can't win
            if((mask &(1<<i))  == 0 && helper(mask | (1<<i),curSum+i+1) == -1)  { //p(i+" i");
                dp[mask] = 1;
                return 1;
            }
        }
        dp[mask] = -1;
        return -1;
    }
    void p(String s){
        System.out.println(s);
    }
}
/*
10
11
10
0
10
1
10
12
18
79
5
50
19
190
20
209
*/
