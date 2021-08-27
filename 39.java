// https://leetcode.com/problems/combination-sum/

class Solution {
    /*
    Here we can use recursion(backtracking) to form all such combinations
    As we know that numbers in condidate are unique so
    we will get unique combinations
    
    Lets we have n candidates and k is target

    T(n,k) = n { T(n,k-1) + T(n-1,k)}
    
    Intitutively as we know that in any combination a number can be present between [0,k] times
    so for all nos k*k*k*k.... n times
    TC : O(K^n)
    SC : O(max(k,n)) : depth of recursion stack

    
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        helper(candidates,target,res,0,new ArrayList());
        return res;
    }
    void helper(int[] candidates, int target, List<List<Integer>> res,int index, List<Integer> cur){
        //base case
        if(target == 0){
            res.add(new ArrayList(cur));
            return;
        }
        if(target < 0 || index >= candidates.length) return;
        // recursive call
        for(int i = index ; i < candidates.length ; i++){
            cur.add(candidates[i]);
            helper(candidates,target-candidates[i],res,i,cur);
            cur.remove(cur.size()-1);
        }
    }
}
