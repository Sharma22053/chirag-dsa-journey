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
class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode current = root;
        while(current != null){
            stack.push(current);
            if(current.left != null) current = current.left;
            else break;
        }
    }
    
    public int next() {
        TreeNode node = stack.pop();
        TreeNode curr = node;
        if(curr.right != null){
            curr = curr.right;
            while(curr != null){
                stack.push(curr);
                if(curr.left != null){
                    curr = curr.left;
                } else break;
            }
        }
        return node.val; 
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */