class Solution {
    public boolean evaluateTree(TreeNode root) {
        
        // Leaf node
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        // Recursively evaluate left and right subtrees
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        // OR operation
        if (root.val == 2) {
            return left || right;
        }

        // AND operation
        return left && right;
    }
}