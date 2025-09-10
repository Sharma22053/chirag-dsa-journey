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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return helper2(list,0,list.size()-1);
    }

    private TreeNode helper2(List<Integer> list,int start,int end){
        if(start > end) return null;
        int mid = start + (end - start) / 2;

        TreeNode left = helper2(list,start,mid-1);
        TreeNode right = helper2(list,mid+1,end);

        TreeNode node = new TreeNode(list.get(mid),left,right);
        return node;
    }

    private void helper(TreeNode root,List<Integer> list){
        if(root == null) return;
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }

}