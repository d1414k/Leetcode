// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
class Solution {
    /*
    Method 1 :
    We can use inorder traversal and save it in an array
    update this array from right to left
    then do inorder traversal again and update these values from array to treeNode
    
    Method 2 :
    We can use reverse inorder traversal with one static variable
    TC : O(n) 
    SC : O(n)
    */
    public static int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        helper(root);
        return root;
    }
    void helper(TreeNode root) {
        if(root == null) return ;
        helper(root.right);
        root.val += sum;
        sum = root.val;
        helper(root.left);
    }
}
