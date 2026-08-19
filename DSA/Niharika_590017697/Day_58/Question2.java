import java.util.*;
public class Question2 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode buildTree(int[] tree, int index) {
        if (index >= tree.length || tree[index] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(tree[index]);

        root.left = buildTree(tree, 2 * index + 1);
        root.right = buildTree(tree, 2 * index + 2);

        return root;
    }

    static boolean exists(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        return exists(root.left, target) ||
               exists(root.right, target);
    }

    static TreeNode findLCA(TreeNode root, int a, int b) {
        if (root == null) {
            return null;
        }

        if (root.val == a || root.val == b) {
            return root;
        }

        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] tree = new int[n];

            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }

            int a = sc.nextInt();
            int b = sc.nextInt();

            TreeNode root = buildTree(tree, 0);

            if (!exists(root, a) || !exists(root, b)) {
                System.out.println(-1);
            } else {
                TreeNode lca = findLCA(root, a, b);
                System.out.println(lca.val);
            }
        }

        sc.close();
    }
}