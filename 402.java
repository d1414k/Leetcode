// https://leetcode.com/problems/remove-k-digits/
class Solution {
    // https://www.youtube.com/watch?v=3QJzHqNAEXs
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k) return "0";
        char s[] = num.toCharArray();
        Deque<Character> stack = new ArrayDeque();
        for(int i = 0 ; i < n ; i++) {
            while(!stack.isEmpty() && k > 0 && stack.peek() > s[i]){ // remove peek element
                k--;
                stack.pop();
            }
            if(stack.isEmpty() && s[i] == '0') continue;
            stack.push(s[i]);
        }
        while(!stack.isEmpty() && k > 0){ // remove from last
            k--;
            stack.pop();
        }
        char []res = new char[stack.size()];
        int size = stack.size();
        for(int i = size - 1 ; i >= 0 ; i--){
            res[i] = stack.pop();
        }
        return size == 0 ? "0" : String.valueOf(res);
    }
} 
// class Solution {
//     public String removeKdigits(String num, int k) {
//         int n = num.length();
//         if(n == k) return "0";
//         char s[] = num.toCharArray(), res[] = new char[n-k];
//         PriorityQueue<Integer> pq = new PriorityQueue<Integer>((Integer x, Integer y)->{
//             if(s[x] == s[y])
//                 return x - y;
//             return s[x] - s[y];
//         });
//         for(int i = 0 ; i < k ; i++) {
//             pq.add(i);
//         }
//         int lastIndex = -1, i = k, k1 = k; // k1 is copy of k
//         for(; i < n ; i++) {
//             pq.add(i);
//             int index = lastIndex;
//             while(!pq.isEmpty() && index <= lastIndex){
//                 index = pq.poll();
//             }
//             if(index - lastIndex - 1 > k)
//                 break;
//             res[i-k1] = s[index];
//             k -= index - lastIndex - 1;
//             if(k == 0){
//                 i++;
//                 break;
//             }
//             lastIndex = index;
//         }
//         for(; i < n ; i++) {
//             res[i-k1] = s[i];
//         }
//         for(i = 0 ; i < res.length && res[i] == '0' ; i++);// remove leading zero
//         String ans = String.valueOf(res, i, res.length-i);
//         return ans.length() == 0 ? "0" : ans;
//     }
// } 
