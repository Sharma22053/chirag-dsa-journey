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
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return count;
    }
    private Pair helper(TreeNode root){
        if(root == null) return new Pair(0,0);
        Pair left = helper(root.left);
        Pair right = helper(root.right);

        int sum = root.val + left.sum + right.sum;
        int nodes = 1 + left.noOfNodes + right.noOfNodes;

        if(sum / nodes == root.val) count++;
        return new Pair(sum,nodes);
    }
}
class Pair{
    int sum;
    int noOfNodes;
    Pair(int sum , int noOfNodes){
        this.sum = sum;
        this.noOfNodes = noOfNodes;
    }
}