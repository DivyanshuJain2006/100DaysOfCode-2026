class Solution {
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        // If current value is smaller than low,
        // ignore the left subtree.
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // If current value is greater than high,
        // ignore the right subtree.
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // Current value is in the range
        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
}