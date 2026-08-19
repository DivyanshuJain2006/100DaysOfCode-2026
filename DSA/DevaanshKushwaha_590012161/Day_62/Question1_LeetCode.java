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
    public boolean evaluateTree(TreeNode root) {
        // Leaf node: value is directly 0 (False) or 1 (True)
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        // Non-leaf: evaluate children first (post-order)
        boolean leftVal = evaluateTree(root.left);
        boolean rightVal = evaluateTree(root.right);

        // Apply the operator at this node
        if (root.val == 2) {          // OR
            return leftVal || rightVal;
        } else {                      // AND (val == 3)
            return leftVal && rightVal;
        }
    }
}
