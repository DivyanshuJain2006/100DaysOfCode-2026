import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static boolean evaluateTree(TreeNode root) {

        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean leftResult = evaluateTree(root.left);
        boolean rightResult = evaluateTree(root.right);

        if (root.val == 2) {
            return leftResult || rightResult;
        }

        return leftResult && rightResult;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(1);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        boolean result = evaluateTree(root);

        System.out.println("Evaluation result: " + result);
    }
}