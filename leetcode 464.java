// https://leetcode.com/problems/can-i-win/
// https://leetcode.com/problems/can-i-win/discuss/95277/Java-solution-using-HashMap-with-detailed-explanation
class Solution {
    Map<Integer,Boolean> dp = null;
    int maxChoosableInteger,desiredTotal;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        dp = new HashMap();
        this.maxChoosableInteger = maxChoosableInteger;
        this.desiredTotal = desiredTotal;
        if(desiredTotal < 0 || (maxChoosableInteger*(maxChoosableInteger+1))/2 < desiredTotal )
            return false;
        if(desiredTotal <= maxChoosableInteger)
            return true;
        return helper(0,0);
    }
    // It returns true if A wins
    boolean helper(int mask,int curSum){
        if(curSum >= desiredTotal)
             return false;
        if(dp.containsKey(mask)) return dp.get(mask);
        boolean res = false;//p(curSum+"");
        for(int i = 1 ; i <= maxChoosableInteger ; i++){// for A
            // i can choose this no and opponent can't win
            if((mask &(1<<i))  == 0 && !helper(mask | (1<<i),curSum+i)) { //p(i+" i");
                dp.put(mask,true);
                return true;
            }
        }
        dp.put(mask,false);
        return false;
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
