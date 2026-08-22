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
    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int lower, int upper) {

        // No elements left
        if (i == preorder.length) {
            return null;
        }

        // Current value doesn't belong in this subtree
        if (preorder[i] <= lower || preorder[i] >= upper) {
            return null;
        }

        // Create the current node
        TreeNode root = new TreeNode(preorder[i]);
        i++;

        // Left subtree: values must be smaller than root
        root.left = build(preorder, lower, root.val);

        // Right subtree: values must be greater than root
        root.right = build(preorder, root.val, upper);

        return root;
    }
}