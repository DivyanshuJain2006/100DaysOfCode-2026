import java.util.*;
class Question2 {

    static int count = 0;
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static void dfs(TreeNode root, int maxValue) {
        if (root == null) {
            return;
        }

        if (root.val >= maxValue) {
            count++;
            maxValue = root.val;
        }

        dfs(root.left, maxValue);
        dfs(root.right, maxValue);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(5);

        dfs(root, Integer.MIN_VALUE);

        System.out.println(count);
    }
}