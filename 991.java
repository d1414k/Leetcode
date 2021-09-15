// https://leetcode.com/problems/broken-calculator/

class Solution {
    /*
    start from end allowed opetaions : division and addition
    if we can devide it
    else +1
    */
    public int brokenCalc(int startValue, int target) {
        int res = 0;
        while(target > startValue){
            if((target&1) == 0)
                target /= 2;
            else
                target++;
            res++;
        }
        return res + startValue - target;
    }
}

