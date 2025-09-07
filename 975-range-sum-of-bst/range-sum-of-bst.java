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
    ArrayList<Integer> list = new ArrayList<>();
    public int rangeSumBST(TreeNode root, int low, int high) {
        int result = 0;
        helper(root,low,high,list);
        for(int i: list){
            result += i;
        }
        return result;
    }
    private void helper(TreeNode root,int low,int high,ArrayList<Integer> list){
        if(root == null) return;
        if(root.val >= low && root.val <= high) list.add(root.val);

        helper(root.left,low,high,list);
        helper(root.right,low,high,list);
        
    }
}