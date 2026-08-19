class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Current value is smaller than the range
        // So ignore the left subtree
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // Current value is greater than the range
        // So ignore the right subtree
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // Current value is within [low, high]
        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
}
