import java.util.*;
public class Question2 {
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

        if (root.val < k) {
            TreeNode[] result = splitBST(root.right, k);
            root.right = result[0];
            return new TreeNode[]{root, result[1]};
        } else {

            TreeNode[] result = splitBST(root.left, k);
            root.left = result[1];
            return new TreeNode[]{result[0], root};
        }
    }

    static void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    static String getPreorder(TreeNode root) {
        if (root == null) {
            return "EMPTY";
        }
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);
        int k = 10;
        TreeNode[] result = splitBST(root, k);

        System.out.println(getPreorder(result[0]));
        System.out.println(getPreorder(result[1]));
    }
}