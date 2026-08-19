
class Question1_leetcode {

    public boolean evaluateTree(TreeNode root) {

        // A leaf node's value IS the boolean result directly
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean leftResult = evaluateTree(root.left);
        boolean rightResult = evaluateTree(root.right);

        if (root.val == 2) {
            return leftResult || rightResult;
        } else {
            return leftResult && rightResult;
        }
    }
}
