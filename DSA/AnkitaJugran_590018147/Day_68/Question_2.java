import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class LargestBSTSubtree {

    // Bundle of info returned from each subtree
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

    static int maxSize = 0;

    public static int largestBSTSubtree(TreeNode root) {
        maxSize = 0;
        postorder(root);
        return maxSize;
    }

    private static Info postorder(TreeNode node) {
        if (node == null) {
            // neutral element: valid BST, size 0,
            // min = +INF, max = -INF so parent comparisons always pass
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = postorder(node.left);
        Info right = postorder(node.right);

        if (left.isBST && right.isBST && left.max < node.val && node.val < right.min) {
            int size = left.size + right.size + 1;
            int min = (node.left == null) ? node.val : left.min;
            int max = (node.right == null) ? node.val : right.max;

            maxSize = Math.max(maxSize, size);
            return new Info(true, size, min, max);
        }

        // Not a valid BST here — mark invalid so parent won't try to merge with it
        return new Info(false, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Helper to build the example tree: [10, 5, 15, 1, 8, -1, 7]
    // level order, -1 means null child
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.left = null;       // -1
        root.right.right = new TreeNode(7);

        System.out.println("Largest BST subtree size: " + largestBSTSubtree(root));
        // Expected output: 3   (the subtree {5, 1, 8} is the largest valid BST)
    }
}