// https://leetcode.com/problems/painting-a-grid-with-three-different-colors/

class Solution {
    /*
    00 : No color, 01 : Red, 10 : Green, 11 : Bule
    mask : 00 01 10 01 ... {This represent color on each row}
    */
    
    public static final long mod = (long)(1e9+7);
    static List<Integer> []neiDp = new ArrayList[1001];
    int [][]dp;
    
    // m rows and n columns
    public int colorTheGrid(int m, int n) {
        dp = new int[n+1][1024];
        for(int i = 0 ; i <= n ; i++) { 
            Arrays.fill(dp[i], -1);
        }
        return helper(m, n, 0);  
    }
    
    int helper(int m, int n, int prevColMask) {
       if(n == 0)
           return 1;
        if(dp[n][prevColMask] != -1) return dp[n][prevColMask];
        
        long res = 0;
       
        if (neiDp[prevColMask] == null) {
            List<Integer> neighbours = new ArrayList();
            generate(m, prevColMask, 0, 0, neighbours);
            neiDp[prevColMask] = neighbours;
        }
        
        for(int nei : neiDp[prevColMask]) {
            res = (res + helper(m, n-1, nei))%mod;
        }
        return dp[n][prevColMask] = (int)res;
    }
    
    void generate(int m, int prevColMask, int curMask, int prevColor, List<Integer> res) {
        if(m == 0) {
            res.add(curMask); 
            return;
        }
        for(int i = 1 ; i <= 3 ; i++) {
            // check if u can place this color on mth row
            if (i != prevColor && i != getColor(m, prevColMask)) {
                generate(m-1, prevColMask, setColor(m, curMask, i), i, res);
            }       
        } 
    }
    
    // get color of mth row in mask 
    int getColor(int m, int mask) {
        m--;
        mask &= 3<<(2*m);
        return mask >>= (2*m);
    }
    
     // set color of mth row in mask as i
    int setColor(int m, int mask, int i) {
        m--;
        mask &= ~(3<<(2*m));
        mask |= i<<(2*m);
        return mask;
    }
}
