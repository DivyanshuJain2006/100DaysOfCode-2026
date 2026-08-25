import java.util.*;

class Solution {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        // 1. Store BST values in sorted order
        inorder(root, values);

        // 2. Build balanced BST
        return buildTree(values, 0, values.size() - 1);
    }

    private void inorder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }

    private TreeNode buildTree(List<Integer> values, int left, int right) {
        if (left > right) {
            return null;
        }

        // Middle element becomes root
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(values.get(mid));

        // Build left subtree
        root.left = buildTree(values, left, mid - 1);

        // Build right subtree
        root.right = buildTree(values, mid + 1, right);

        return root;
    }
}