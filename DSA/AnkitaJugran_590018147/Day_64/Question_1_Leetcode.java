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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        // Current value is smaller than the range.
        // Only the right subtree can contain valid values.
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // Current value is larger than the range.
        // Only the left subtree can contain valid values.
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // Current value is inside [low, high].
        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
}