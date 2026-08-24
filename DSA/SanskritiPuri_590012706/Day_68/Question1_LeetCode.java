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
    public TreeNode balanceBST(TreeNode root) {
         java.util.List<Integer> values = new java.util.ArrayList<>();

        inorder(root, values);

        return buildTree(values, 0, values.size() - 1);
    }

    private void inorder(TreeNode root, java.util.List<Integer> values) {
        if (root == null) {
            return;
        }

        inorder(root.left, values);

        values.add(root.val);

        inorder(root.right, values);
    }

    private TreeNode buildTree(java.util.List<Integer> values, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(values.get(mid));

        root.left = buildTree(values, left, mid - 1);
        root.right = buildTree(values, mid + 1, right);

        return root;
        
    }
}
