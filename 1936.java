// https://leetcode.com/problems/add-minimum-number-of-rungs/

class Solution {
    public int addRungs(int[] rungs, int dist) {
        int cur = 0, res = 0;
        for(int h : rungs){
            if(h - cur > dist){
                res += (h - cur - 1)/dist;
            }
            cur = h;
        }
        return res;
    }
}
/*
[1,3,5,10]
2
[3,6,8,10]
3
[3,4,6,7]
2
[5]
10
[3]
1
[12,24]
4
*/
