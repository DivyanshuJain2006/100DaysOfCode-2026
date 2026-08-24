package DSA.TanmaySharma_590011578.Day_62;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Question2 {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int robThis = node.val + left[1] + right[1];
        int skipThis = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{robThis, skipThis};
    }

    public static TreeNode buildTree(int[] values) {
        if (values.length == 0 || values[0] == -1) {
            return null;
        }
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            TreeNode node = queue.poll();
            if (index < values.length && values[index] != -1) {
                node.left = new TreeNode(values[index]);
                queue.offer(node.left);
            }
            index++;
            if (index < values.length && values[index] != -1) {
                node.right = new TreeNode(values[index]);
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] tree = {3, 2, 3, -1, 3, -1, 1};
        TreeNode root = buildTree(tree);
        Question2 question = new Question2();
        System.out.println(question.rob(root));
    }
}