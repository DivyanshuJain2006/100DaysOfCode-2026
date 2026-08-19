import java.util.*;

class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int findLCA(int[] tree, int a, int b) {

        // Create nodes for all non-null values
        TreeNode[] nodes = new TreeNode[tree.length];

        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != -1) {
                nodes[i] = new TreeNode(tree[i]);
            }
        }

        // Connect left and right children
        for (int i = 0; i < tree.length; i++) {

            if (nodes[i] == null) {
                continue;
            }

            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;

            if (leftIndex < tree.length) {
                nodes[i].left = nodes[leftIndex];
            }

            if (rightIndex < tree.length) {
                nodes[i].right = nodes[rightIndex];
            }
        }

        TreeNode root = nodes[0];

        // Find the two employees
        TreeNode nodeA = findNode(root, a);
        TreeNode nodeB = findNode(root, b);

        // If either employee doesn't exist
        if (nodeA == null || nodeB == null) {
            return -1;
        }

        // Find LCA
        TreeNode lca = lowestCommonAncestor(root, a, b);

        return lca.val;
    }

    // Search for an employee
    private static TreeNode findNode(TreeNode root, int value) {

        if (root == null) {
            return null;
        }

        if (root.val == value) {
            return root;
        }

        TreeNode leftResult = findNode(root.left, value);

        if (leftResult != null) {
            return leftResult;
        }

        return findNode(root.right, value);
    }

    // Find Lowest Common Ancestor
    private static TreeNode lowestCommonAncestor(
            TreeNode root, int a, int b) {

        if (root == null) {
            return null;
        }

        // If current node is either a or b
        if (root.val == a || root.val == b) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, a, b);
        TreeNode right = lowestCommonAncestor(root.right, a, b);

        // One node found in left and one in right
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side contains a node
        if (left != null) {
            return left;
        }

        return right;
    }
}