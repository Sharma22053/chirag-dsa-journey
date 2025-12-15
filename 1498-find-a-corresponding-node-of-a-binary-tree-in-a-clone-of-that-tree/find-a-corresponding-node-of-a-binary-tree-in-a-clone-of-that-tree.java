/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode toFind;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        toFind = target;
        return helper(cloned);
    }
    private TreeNode helper(TreeNode root){
        if(root == null) return null;
        if(root.val == toFind.val) return root;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        return left == null ? right :left;
    }
}