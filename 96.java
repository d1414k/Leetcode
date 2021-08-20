// https://leetcode.com/problems/unique-binary-search-trees/

class Solution {// overflow => wrong ans
    /*
    Appraoch 1:
    2nCn/(n+1)

    2n!
    ---------
    n!(n+1)!


    2n* (2n-1) * .....(n+2)
    ------------------------
    n* (n-1) * .........1
    
    Input : 19
    Output : -5
    */
    // public int numTrees(int n) {
    //     long x = 1, y = 1;
    //     for(int i = 2*n ; i >= n+2 ; i--)
    //         x *= i;
    //     for(int i = 1 ; i <= n ; i++)
    //         y *= i;
    //     //System.out.println(x+" "+y);
    //     return (int)(x/y);
    // }
    
    // Approach 2 using dp
    /*
            total = n nodes
            
            (1)
          j     n - 1- j
    
    f(n) = f(j) + f(n-1-j)   where j = 0 to n-1
    
    Base case : 
    f(0) = f(1) = 1
    */
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            for(int j = 0 ; j < i ; j++){
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }
}

/*



*/
