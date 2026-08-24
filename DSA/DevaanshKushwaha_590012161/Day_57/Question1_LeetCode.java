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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        int sum = 0;
        
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                // Left child is a leaf, add its value
                sum += root.left.val;
            } else {
                // Left child has children, recurse into it
                sum += sumOfLeftLeaves(root.left);
            }
        }
        
        // Always recurse into the right subtree (never add its leaves directly)
        sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
}
