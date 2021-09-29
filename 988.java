//https://leetcode.com/problems/smallest-string-starting-from-leaf/

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
    public String smallestFromLeaf(TreeNode root) {
       if(root == null)
           return "";
        int h = height(root);
        int res[] = new int[h];
        Arrays.fill(res, 26);
        helper(root, 0, new int[h], res);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < h ; i++) {
            if(res[i] == 26) break;
            sb.append((char)(res[i]+'a'));
        }
        return sb.toString();
    }
    void helper(TreeNode root, int level, int []temp, int []res) {
        if(root == null) return;
        temp[level] = root.val;
        if(root.left == null && root.right == null) {
            boolean isSmaller = true;
            for(int i = level, j = 0 ; i >= 0 ; i--, j++) {
                if(temp[i] > res[j]){
                    isSmaller = false;
                    break;
                }
                else if(temp[i] < res[j])
                    break;
            }
            if(isSmaller) {
                int i = level, j = 0;
                for(; i >= 0 ; i--, j++) {
                    res[j] = temp[i];
                }
                for(; j < res.length ;j++) {
                    res[j] = 26;
                }
            }
        }
        helper(root.left,level+1, temp, res);
        helper(root.right,level+1, temp, res);
    }
    
    int height(TreeNode root) {
        if(root == null) 
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
