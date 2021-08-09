// https://leetcode.com/problems/create-maximum-number/
// https://leetcode.com/problems/create-maximum-number/discuss/77287/C%2B%2B-16ms-FASTEST-beats-97.
class Solution {
    int []res = null;
    int []temp = null;
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // we need to take total k nos.
        // we will try taking i nos from nums1 and k-i nums from nums2
        int n = nums1.length;
        int m = nums2.length;
        res = new int[k];
        temp = new int[k];
        Arrays.fill(res,-1);
        // helper(nums1,nums2,k);
        // here it might possible that nums2 does not have k element in that case 'i' will start from k-m
        for(int i = Math.max(0,k-m) ; i <= k && i <= n ; i++) {
            Stack<Integer> stack1 = getNums(nums1,i);
            Stack<Integer> stack2 = getNums(nums2,k-i);//System.out.println(stack1+" "+stack2+" "+i);
            merge(stack1,stack2,k);
            updateMax(k);//System.out.println(Arrays.toString(res)+"");
        }
        return res;
    } 
  
    Stack<Integer> getNums(int []nums, int i){
        Stack<Integer> stack = new Stack();
        if(i == 0) return stack;
        for(int j = 0 ; j < nums.length ; j++){
            while (!stack.empty() && stack.peek() < nums[j] && stack.size() + nums.length - j - 1 >= i)
                stack.pop();
            stack.push(nums[j]);   
        }
        return stack;
    }
    void merge(Stack<Integer> stack1, Stack<Integer> stack2,int k){
        Collections.reverse(stack1);
        Collections.reverse(stack2);
        for(int i = 0 ; i < k ; i++){
            if(stack1.empty()){
                temp[i] = stack2.pop();
            }
            else if(stack2.empty()){
                temp[i] = stack1.pop();
            }
            else{//System.out.print(stack1.peek() +" "+ stack2.peek()+" ");
                if(stack1.peek() > stack2.peek()){
                    temp[i] = stack1.pop();
                }else if(stack1.peek() < stack2.peek()){
                    temp[i] = stack2.pop();
                }else{
                    if(check(stack1,stack2)){
                        temp[i] = stack1.pop();
                    }else{
                        temp[i] = stack2.pop();
                    }
                }
               // System.out.println(temp[i]);
            }
        }
    }
    void updateMax(int k){
        for(int i = 0 ; i < k ; i++){
            if(res[i] != temp[i]){
               if(res[i] < temp[i]){
                    int []t = res;
                    res = temp;
                    temp = t;
                }
                return;
            }
        }
    }
    // true if stack1 wins else false
    boolean check(Stack<Integer> stack1, Stack<Integer> stack2){
        List<Integer> list1 = new ArrayList(stack1);
        List<Integer> list2 = new ArrayList(stack2);
        Collections.reverse(list1);
        Collections.reverse(list2);
        int n = Math.min(list1.size(), list2.size());
        for(int i = 0 ; i < n ; i++){
            if(list1.get(i) != list2.get(i)){ //System.out.println("check: "+list1.get(i) +" "+ list2.get(i));
                if(list1.get(i) > list2.get(i))
                    return true;
                else
                    return false;
            }
        }
        return list1.size() > list2.size();
    }
}
// class Solution { // wrong
//     public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//         int n = nums1.length, m = nums2.length;
//         int []res = new int[k];
//         List<Node> list = new ArrayList();
//         int maxSoFor = -1; 
//         for(int i = 0; i < n ; i++){
//             list.add(new Node(true,nums1[i],i,maxSoFor));
//             maxSoFor = Math.max(maxSoFor,nums1[i]);
//         }
//         maxSoFor = -1; 
//         for(int i = 0; i < m ; i++){
//             list.add(new Node(false,nums2[i],i,maxSoFor));
//             maxSoFor = Math.max(maxSoFor,nums2[i]);
//         }
//         Collections.sort(list,(Node p, Node q)->{
//             if(p.val == q.val){
//                 if(p.index != q.index)
//                     return p.index - q.index;
//                 return p.maxSoFor - q.maxSoFor;
//             }
//             return q.val-p.val;
//         });System.out.println(list);
//         int i = -1, j = -1;// both array index
//         for(int l = 0 ; l < k ; l++){
//             for(int x = 0 ; x < list.size() ; x++){
//                 Node p = list.get(x);
//                 if(p.isNum1){
//                     if(p.index > i && n+m-p.index-j-2 >= k-l-1){
//                         i = p.index;
//                         res[l] = p.val;
//                         list.remove(x);
//                         break;
//                     }
//                 }
//                 else{
//                      if(p.index > j && n+m-i-p.index-2 >= k-l-1){
//                         j = p.index;
//                         res[l] = p.val;
//                         list.remove(x);
//                         break;
//                     } 
//                 }
//             }System.out.println(res[l]+" "+i+" "+j);
//         }
//         return res;
//     }
// }
// class Node {
//     boolean isNum1;
//     int val,index,maxSoFor;
//     Node(boolean isNum1,int val,int index,int maxSoFor){
//         this.isNum1 = isNum1;
//         this.val = val;
//         this.index = index;
//         this.maxSoFor = maxSoFor;
//     }
//     public String toString() {
//         return isNum1+" "+val +" "+index;
//     }
// }
/*
[3,4,6,5]
[9,1,2,5,8,3]
5
[6,7]
[6,0,4]
5
[3,9]
[8,9]
3
[8,9]
[3,9]
3
[2,5,6,4,4,0]
[7,3,8,0,6,5,7,6,2]
15
[2,8,0,4,5,1,4,8,9,9,0,8,2,9]
[5,9,6,6,4,1,0,7]
22
[3,4,8,9,3,0]
[6,1,9,1,1,2]
6
*/
