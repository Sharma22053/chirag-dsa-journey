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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    private Pair dfs(TreeNode root){
        if(root == null) return new Pair(null,0);
        Pair L = dfs(root.left);
        Pair R = dfs(root.right);

        if(L.distance > R.distance ) return new Pair(L.node,L.distance+1);
        if(L.distance < R.distance) return new Pair(R.node,R.distance+1);
        return new Pair(root,L.distance+1);
    }
}
class Pair{
    TreeNode node;
    int distance;
    Pair(TreeNode n , int distance){
        this.node = n;
        this.distance=  distance;
    }
}