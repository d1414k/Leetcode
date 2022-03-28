 // https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/

//https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/discuss/574943/Java-Detailed-Explanation-with-Graph-Demo-DP-Easy-Understand

class Solution {
    public static final int mod = (int)1e9 + 7;
    public int numOfWays(int n) {
        long color3, color2;
        color3 = color2 = 6;
        for(int i = 2 ; i <= n ; i++) {
            long temp = color3;
            color3 = (2*color3 + 2*color2)%mod;
            color2 = (2*temp + 3*color2)%mod;
        }
        return (int)(color3 + color2)%mod;
    }
}
