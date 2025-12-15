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
    Map<Integer, List<TreeNode>> dp = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (dp.containsKey(n))
            return dp.get(n);

        List<TreeNode> result = new ArrayList<>();
        if (n % 2 == 0) {
            dp.put(n, result);
            return result;
        }

        if (n == 1) {
            result.add(new TreeNode(0));
            dp.put(n, result);
            return result;
        }

        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);

            for (TreeNode L : left) {
                for (TreeNode R : right) {
                    TreeNode temp = new TreeNode(0);
                    temp.left = cloneTree(L);
                    temp.right = cloneTree(R);
                    result.add(temp);
                }
            }

        }
        dp.put(n, result);
        return result;
    }

    private TreeNode cloneTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = cloneTree(root.left);
        newRoot.right = cloneTree(root.right);
        return newRoot;

    }

}