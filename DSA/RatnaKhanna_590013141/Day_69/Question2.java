import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode[] splitBST(TreeNode root, int k) {

        if (root == null) {
            return new TreeNode[]{null, null};
        }

        // Root belongs to left BST
        if (root.val < k) {
            TreeNode[] result = splitBST(root.right, k);

            root.right = result[0];

            return new TreeNode[]{root, result[1]};
        }

        // Root belongs to right BST
        else {
            TreeNode[] result = splitBST(root.left, k);

            root.left = result[1];

            return new TreeNode[]{result[0], root};
        }
    }

    static void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        if (sb.length() > 0) {
            sb.append(" ");
        }

        sb.append(root.val);

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    static TreeNode insert(TreeNode root, int value) {

        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.val) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of nodes
        int n = sc.nextInt();

        TreeNode root = null;

        // Read BST values
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insert(root, value);
        }

        // Read K
        int k = sc.nextInt();

        TreeNode[] result = splitBST(root, k);

        // Preorder of first BST
        StringBuilder left = new StringBuilder();
        preorder(result[0], left);

        // Preorder of second BST
        StringBuilder right = new StringBuilder();
        preorder(result[1], right);

        if (left.length() == 0) {
            System.out.println("EMPTY");
        } else {
            System.out.println(left);
        }

        if (right.length() == 0) {
            System.out.println("EMPTY");
        } else {
            System.out.println(right);
        }

        sc.close();
    }
}
