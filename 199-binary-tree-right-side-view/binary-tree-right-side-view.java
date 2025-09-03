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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer,Integer> treeMap = new TreeMap<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair current = queue.poll();
            TreeNode node = current.node;
            int depth = current.depth;
            if(!treeMap.containsKey(depth)){
                treeMap.put(depth,node.val);
            }

            if(node.right != null) queue.add(new Pair(node.right,depth+1));
            if(node.left != null) queue.add(new Pair(node.left,depth+1));

        }

        result.addAll(treeMap.values());
        return result;
    }
    class Pair{
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
}