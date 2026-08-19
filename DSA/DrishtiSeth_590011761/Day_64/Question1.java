class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }

        // If current value is smaller than low,
        // ignore left subtree
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // If current value is greater than high,
        // ignore right subtree
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // Current value is in range
        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
}
