import java.util.*;

public class Question2 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static boolean exists(TreeNode root, int x) {

        if (root == null) {
            return false;
        }

        if (root.val == x) {
            return true;
        }

        return exists(root.left, x) || exists(root.right, x);
    }

    static TreeNode lca(TreeNode root, int a, int b) {

        if (root == null || root.val == a || root.val == b) {
            return root;
        }

        TreeNode left = lca(root.left, a, b);
        TreeNode right = lca(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    static TreeNode buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                nodes[i] = new TreeNode(arr[i]);
            }
        }

        for (int i = 0; i < arr.length; i++) {

            if (nodes[i] != null) {

                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (left < arr.length) {
                    nodes[i].left = nodes[left];
                }

                if (right < arr.length) {
                    nodes[i].right = nodes[right];
                }
            }
        }

        return nodes[0];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {

            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int a = sc.nextInt();
            int b = sc.nextInt();

            TreeNode root = buildTree(arr);

            if (!exists(root, a) || !exists(root, b)) {
                System.out.println(-1);
            } else {
                System.out.println(lca(root, a, b).val);
            }
        }

        sc.close();
    }
}