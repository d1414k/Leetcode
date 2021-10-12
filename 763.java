// https://leetcode.com/problems/partition-labels/
class Solution {
    public List<Integer> partitionLabels(String s) {
        int lastIndex[] = new int[26], n = s.length();
        for(int i = 0 ; i < n ; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList();
        for(int i = 0 ; i < n ;) {
            int low = i, high = i;
            while(i <= high){
                high = Math.max(high, lastIndex[s.charAt(i++) - 'a']);
            }
            res.add(high-low+1);
        }
        return res;
    }
}
