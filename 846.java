// https://leetcode.com/problems/hand-of-straights/
class Solution {
    /*
    Add all elements into a hashMap with value as its count
    save keyset in an array and sort it.
    now pick groupsize elements and decrement its count from map
    TC: 0(nlogn)
    SC: 0(n)
    */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
            return false;
        HashMap<Integer,Integer> map = new HashMap();
        for(int x : hand) {
            map.put(x, map.getOrDefault(x,0) + 1);
        }
        int n = 0;
        for(int x : map.keySet()){
            hand[n++] = x;
        }
        Arrays.sort(hand,0,n);
        int index = 0;
        while(index < n) {
            int count = groupSize;
            int cur = hand[index];
            while(count-- > 0) {
                Integer freq = map.get(cur);
                if(freq == null || freq == 0)
                    return false; 
                if(freq == 1)
                    index++;
                else
                    map.put(cur, freq - 1);
                cur++;
            }
        }
        return true;
    }
}
