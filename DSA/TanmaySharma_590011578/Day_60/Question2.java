package DSA.TanmaySharma_590011578.Day_60;
import java.util.*;

public class Question2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int countSafeNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return countSafeNodes(root, Integer.MIN_VALUE);
    }

    private static int countSafeNodes(TreeNode node, int maxValue) {
        if (node == null) {
            return 0;
        }

        int count = 0;

        if (node.val >= maxValue) {
            count = 1;
        }

        int newMax = Math.max(maxValue, node.val);

        count += countSafeNodes(node.left, newMax);
        count += countSafeNodes(node.right, newMax);

        return count;
    }

    public static TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();

            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] values = {3, 1, 4, 3, null, 1, 5};

        TreeNode root = buildTree(values);

        int result = countSafeNodes(root);

        System.out.println("Number of safe campsites: " + result);
    }
}