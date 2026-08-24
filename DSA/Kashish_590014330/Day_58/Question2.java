import java.util.*;

public class Question2 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    static boolean exists(TreeNode root, int value) {

        if (root == null)
            return false;

        if (root.val == value)
            return true;

        return exists(root.left, value) ||
               exists(root.right, value);
    }
    static TreeNode findLCA(TreeNode root, int a, int b) {

        if (root == null)
            return null;

        if (root.val == a || root.val == b)
            return root;

        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);

        if (left != null && right != null)
            return root;

        if (left != null)
            return left;

        return right;
    }


    static TreeNode buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1)
            return null;

        TreeNode[] nodes = new TreeNode[arr.length];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != -1)
                nodes[i] = new TreeNode(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {

            if (nodes[i] == null)
                continue;

            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;

            if (leftIndex < arr.length)
                nodes[i].left = nodes[leftIndex];

            if (rightIndex < arr.length)
                nodes[i].right = nodes[rightIndex];
        }

        return nodes[0];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

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
                continue;
            }

            TreeNode lca = findLCA(root, a, b);

            System.out.println(lca.val);
        }

        sc.close();
    }
}