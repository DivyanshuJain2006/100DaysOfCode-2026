package Day_58;
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

    static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    static boolean exists(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        return exists(root.left, target) || exists(root.right, target);
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
        int n = sc.nextInt();
        int[] tree = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        TreeNode root = buildTree(tree);

        if (!exists(root, a) || !exists(root, b)) {
            System.out.println(-1);
        } else {
            TreeNode lca = findLCA(root, a, b);
            System.out.println(lca.val);
        }
        sc.close();
    }
}