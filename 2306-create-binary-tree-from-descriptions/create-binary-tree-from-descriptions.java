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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> children = new HashSet<>(), parent = new HashSet<>();
        Map<Integer, List<int[]>> hmap = new HashMap<>();

        for (int[] edge : descriptions) {
            int child = edge[1] , prnt = edge[0] , isLeft = edge[2];
            parent.add(prnt);
            parent.add(child);
            children.add(child);
            hmap.computeIfAbsent(prnt, l -> new ArrayList<>())
                .add(new int[] { child, isLeft });
        }

        parent.removeAll(children);
        TreeNode root = new TreeNode(parent.iterator().next());

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode currentParent = queue.poll();
            for(int[] childInfo : hmap.getOrDefault(currentParent.val,Collections.emptyList())){
                int childValue = childInfo[0] , isLeft = childInfo[1];
                TreeNode child = new TreeNode(childValue);
                queue.offer(child);
                if(isLeft == 1){
                    currentParent.left = child;
                } else {
                    currentParent.right = child;
                }
            }
        }
        return root;
    }

}