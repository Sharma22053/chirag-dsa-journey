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
    int max = 0;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        helper(root,1);
        return sum;
    }
    private void helper(TreeNode root,int level){
        if(root == null) return;
        if(level == max) sum += root.val;
        if(level > max){
            max = level;
            sum = root.val;
        }
        helper(root.left,level+1);
        helper(root.right,level + 1);
    }
}