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
    private int preOrderIndex;
    private Map<Integer,Integer> hmap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       hmap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hmap.put(inorder[i],i);
        }
        preOrderIndex = 0;
        return helper(preorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder,int start,int end){
        if(start > end) return null;

        int value = preorder[preOrderIndex++];
        TreeNode node = new TreeNode(value);
        int mid = hmap.get(value);
        node.left = helper(preorder,start,mid-1);
        node.right = helper(preorder,mid+1,end);
        return node;
    }
}