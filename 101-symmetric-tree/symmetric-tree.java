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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode rootLeft,TreeNode rootRight){
        if(rootLeft == null && rootRight == null) return true;
        if(rootLeft == null || rootRight == null) return false;

        
    return rootLeft.val == rootRight.val && helper(rootLeft.left,rootRight.right) && helper(rootLeft.right,rootRight.left);
        
    }
}