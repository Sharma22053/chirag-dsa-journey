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
    private Map<Integer,Integer> hmap;
    private int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        hmap = new HashMap<>();
        index = postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            hmap.put(inorder[i],i);
        }

        return helper(postorder,0,postorder.length-1);
    }
    private TreeNode helper(int[] postorder,int start,int end){
        if(start > end){
            return null;
        }
        int value = postorder[index--];
        TreeNode node = new TreeNode(value);
        int mid = hmap.get(value);
        node.right = helper(postorder,mid+1,end);
        node.left = helper(postorder,start,mid-1);
        return node;
    }
}