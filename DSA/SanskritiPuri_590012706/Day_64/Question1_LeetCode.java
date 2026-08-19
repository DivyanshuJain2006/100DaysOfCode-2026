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

        // If current value is smaller than low,
        // only search the right subtree.
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // If current value is greater than high,
        // only search the left subtree.
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // Current value is within [low, high]
        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
        
    }
}
