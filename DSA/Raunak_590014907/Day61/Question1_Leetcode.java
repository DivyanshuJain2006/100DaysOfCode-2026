class Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null)
            return 0;

        // Current value is smaller than range
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // Current value is greater than range
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // Current value is inside range
        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
}