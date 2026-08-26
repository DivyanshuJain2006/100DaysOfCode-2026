import java.util.*;
class Question2 {
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
            TreeNode[] rightPart = splitBST(root.right, k);
            root.right = rightPart[0];
            return new TreeNode[]{root, rightPart[1]};
        } else {
            TreeNode[] leftPart = splitBST(root.left, k);
            root.left = leftPart[1];
            return new TreeNode[]{leftPart[0], root};
        }
    }
    static void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        if (sb.length() > 0) sb.append(" ");
        sb.append(root.val);
        preorder(root.left, sb);
        preorder(root.right, sb);
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
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
 preorder(result[0], first);
        preorder(result[1], second);

        System.out.println(first.length() == 0 ? "EMPTY" : first);
        System.out.println(second.length() == 0 ? "EMPTY" : second);
    }
}