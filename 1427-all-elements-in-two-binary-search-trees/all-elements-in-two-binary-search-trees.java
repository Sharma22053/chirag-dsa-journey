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
    List<Integer> result;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        result = new ArrayList<>();
        helper(root1);
        helper(root2);
        Collections.sort(result);
        return result;
    }

    private void helper(TreeNode root){
        if(root == null) return;
        result.add(root.val);
        helper(root.left);
        helper(root.right);
    }

    // private void helper(TreeNode root1,TreeNode root2){
    //     if(root1.left == null && root1.left == null){
    //         result.add(root1.val);
    //         return;
    //     }
    //     if(root2.left == null && root2.left == null){
    //         result.add(root2.val);
    //         return;
    //     }
    //     helper(root1.left,root2.left);
    //     helper(root1.right,root2.right);

    // }

}