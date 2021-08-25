// https://leetcode.com/problems/check-completeness-of-a-binary-tree/

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
    As we know that we can store complete binary tree in an array
    so we can check if we can fill this tree in an array of size 'n' or not
    lets root be at index i then 
    left child : 2*i + 1
    right child : 2*t + 2
    
    Appraach 1:
    
    we can find total no of nodes
    then by any traversal we can find max index value of a node
    if it is >= n then false else true
    
    TC : O(n), SC : O(n) and it will take 2 traversal
    
    Appraoch 2:
    
    We can use level order
    In level order index value for each node has to be contiguous
    
    TC : O(n), SC : O(n) and it will take single traversal
    
    */
    public boolean isCompleteTree(TreeNode root) { // Approach 1
        int size = getSize(root);
        return helper(root,1,size);// consider 1 index based
    }
    
    public boolean helper(TreeNode root, int curIndex, int size){
        if(root == null){
            if(curIndex <= size)
                return false;
            return true;
        }
        return helper(root.left,curIndex<<1,size) && helper(root.right,(curIndex<<1) + 1,size);
    }
    
    public int getSize(TreeNode root){
        if(root == null) return 0;
        return 1 + getSize(root.left) + getSize(root.right);
    }
    
    // public boolean isCompleteTree(TreeNode root) { // Approach 2
    //     Queue<Node> queue = new LinkedList<Node>();
    //     queue.add(new Node(root,0));
    //     int lastIndex = 0;
    //     while(!queue.isEmpty()){
    //         Node node = queue.poll();
    //         int index = node.index;
    //         if(node.root.left != null){
    //             if(lastIndex + 1 != (index<<1) + 1)
    //                 return false;
    //             lastIndex++;
    //             queue.add(new Node(node.root.left,lastIndex));
    //         }
    //         if(node.root.right != null){
    //            if(lastIndex + 1 != (index<<1) + 2)
    //                 return false;
    //             lastIndex++;
    //             queue.add(new Node(node.root.right,lastIndex)); 
    //         }
    //     }
    //     return true;
    // }
}
// class Node{
//     TreeNode root;
//     int index;
//     Node(TreeNode root,int index){
//         this.root = root;
//         this.index = index;
//     }
// }
