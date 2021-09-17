// https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/
class Solution {
    /*
    sort then
    Think which no we can not make
    */
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int canntMake = 1;
        for(int x : coins) {
            if(x > canntMake)
                return canntMake;
            canntMake += x;
        }
        return canntMake;
    }
}
/*
[1,3]
[1,1,1,4]
[1,4,10,3,1]
*/
