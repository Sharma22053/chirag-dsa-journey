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
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int globalLevel = 1;
        int currentLevel = 0;
        int finalSum = Integer.MIN_VALUE;
        
        while (!queue.isEmpty()) {
            currentLevel++;
            int size = queue.size();
            int currentSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                currentSum += current.val;
                if (current.left != null) {

                    queue.offer(current.left);
                }
                if (current.right != null) {

                    queue.offer(current.right);
                }
            }
            if (finalSum < currentSum) {
                finalSum = currentSum;
                globalLevel = currentLevel;
            }
        }
        return globalLevel;
    }
}