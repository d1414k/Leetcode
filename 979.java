// https://leetcode.com/problems/distribute-coins-in-binary-tree/

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

class Solution {
    /*
    If we know sum of nodes and sum of coins,
    Its diff will total movement for that edge
    */
    Map<TreeNode, int[]> map = null;
    static int res = 0;
    public int distributeCoins(TreeNode root) {
        map = new HashMap();
        res = 0;
        helper(root);
        return res;
    }
    // return no of excess nodes
    int helper(TreeNode root) {
        if(root == null) 
            return 0;

        int left = helper(root.left); // We got these many node from LST
        int right = helper(root.right);// We got these many node from RST
        
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
    
}
// class Solution {
//     /*
//     If we know sum of nodes and sum of coins,
//     Its diff will total movement for that edge
//     */
//     Map<TreeNode, int[]> map = null;
//     static int res = 0;
//     public int distributeCoins(TreeNode root) {
//         map = new HashMap();
//         res = 0;
//         helper(root);
//         return res;
//     }
    
//     int[] helper(TreeNode root) {
//         if(root == null) 
//             return new int[2];
//         int []a = new int[2]; // size,coins
//         int []left = helper(root.left);
//         int []right = helper(root.right);
//         a[0] = left[0] + right[0] + 1;
//         a[1] = left[1] + right[1] + root.val;
//         res += Math.abs(a[0]-a[1]);
//         return a;
//     }
    
// }
// class Solution {
//     /*
//     If we know sum of nodes and sum of coins,
//     Its diff will total movement for that edge
//     */
//     Map<TreeNode, int[]> map = null;
//     public int distributeCoins(TreeNode root) {
//         map = new HashMap();
//         helper(root);
//         int res = 0;
//         for(Map.Entry<TreeNode,int[]> entry : map.entrySet()) {
//             int []v = entry.getValue();
//             res += Math.abs(v[0]-v[1]);
//         }
//         return res;
//     }
    
//     int[] helper(TreeNode root) {
//         if(root == null) 
//             return new int[2];
//         int []a = new int[2]; // size,coins
//         int []left = helper(root.left);
//         int []right = helper(root.right);
//         a[0] = left[0] + right[0] + 1;
//         a[1] = left[1] + right[1] + root.val;
//         map.put(root,a);
//         return a;
//     }
    
// }
