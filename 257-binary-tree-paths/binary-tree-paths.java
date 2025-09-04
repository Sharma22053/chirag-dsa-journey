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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        if(root == null) return result;
        helper(root,result,"");
        return result;
    }

    private void helper(TreeNode root,ArrayList<String> result,String str){
        if(root.left == null && root.right == null){
            result.add(str+root.val);
            
        }
        if(root.left != null){
            helper(root.left,result,str+root.val+"->");
        }
        if(root.right != null){
            helper(root.right,result,str+root.val+"->");
        }
    }
}