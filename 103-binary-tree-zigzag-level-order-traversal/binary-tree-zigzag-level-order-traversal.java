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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0;i<size;i++){
                if(!flag){
                    TreeNode node = queue.pollFirst();
                    list.add(node.val);
                    if(node.left != null) queue.addLast(node.left);
                    if(node.right != null) queue.addLast(node.right);
                } else {
                     TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if(node.right != null) queue.addFirst(node.right);
                    if(node.left != null) queue.addFirst(node.left);
                }

            }
            flag = !flag;
            result.add(list);
            
        }
        return result;
    }
}