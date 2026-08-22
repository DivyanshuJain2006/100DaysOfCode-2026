import java.util.*;
class Question2 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
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

    static int maxBST = 0;
    static Info dfs(TreeNode node) {
        if (node == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info left = dfs(node.left);
        Info right = dfs(node.right);
        if (left.isBST && right.isBST &&
            node.val > left.max && node.val < right.min) {
            int size = left.size + right.size + 1;
            maxBST = Math.max(maxBST, size);
            int min = Math.min(node.val, left.min);
            int max = Math.max(node.val, right.max);
            return new Info(true, size, min, max);
        }
        return new Info(false, 0, 0, 0);
    }
    static int largestBSTSubtree(TreeNode root) {
        maxBST = 0;
        dfs(root);
        return maxBST;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        System.out.println(largestBSTSubtree(root));
    }
}