import java.util.*;

class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build tree from level-order array
    static TreeNode buildTree(int[] tree) {
        if (tree.length == 0 || tree[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < tree.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < tree.length && tree[i] != -1) {
                current.left = new TreeNode(tree[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < tree.length && tree[i] != -1) {
                current.right = new TreeNode(tree[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Information returned for every subtree
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int largestBST = 0;

    static Info findLargestBST(TreeNode root) {

        // Empty subtree is a valid BST
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = findLargestBST(root.left);
        Info right = findLargestBST(root.right);

        // Check whether current subtree is a BST
        if (left.isBST &&
            right.isBST &&
            root.val > left.max &&
            root.val < right.min) {

            int size = left.size + right.size + 1;

            largestBST = Math.max(largestBST, size);

            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);

            return new Info(true, size, min, max);
        }

        // Current subtree is not a BST
        return new Info(false, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int solve(int n, int[] tree) {

        TreeNode root = buildTree(tree);

        largestBST = 0;
        findLargestBST(root);

        return largestBST;
    }

    public static void main(String[] args) {

        int n = 7;
        int[] tree = {10, 5, 15, 1, 8, -1, 7};

        System.out.println(solve(n, tree));
    }
}