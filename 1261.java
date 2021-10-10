// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {

    HashSet<Integer> hs = new HashSet();
    public FindElements(TreeNode root) {
        helper(root,0);
    }
    
    public boolean find(int target) {
       return hs.contains(target); 
    }
    
    void helper(TreeNode root, int value){
        if(root == null)
            return;
        root.val = value;
        hs.add(value);
        helper(root.left, 2*value + 1);
        helper(root.right, 2*value + 2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
