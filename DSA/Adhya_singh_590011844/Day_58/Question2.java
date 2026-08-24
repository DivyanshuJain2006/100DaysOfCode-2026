import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode lca;
    static boolean foundA, foundB;

    static TreeNode findLCA(TreeNode root, int a, int b) {
        if (root == null) {
            return null;
        }

        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);

        boolean isA = root.val == a;
        boolean isB = root.val == b;

        if (isA) foundA = true;
        if (isB) foundB = true;
        if ((left != null && right != null) ||
            ((isA || isB) && (left != null || right != null))) {
            lca = root;
        }

        if (isA || isB) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }

    static TreeNode buildTree(int[] tree) {
        if (tree.length == 0 || tree[0] == -1) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[tree.length];

        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != -1) {
                nodes[i] = new TreeNode(tree[i]);
            }
        }

        for (int i = 0; i < tree.length; i++) {
            if (nodes[i] != null) {
                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;

                if (leftIndex < tree.length) {
                    nodes[i].left = nodes[leftIndex];
                }

                if (rightIndex < tree.length) {
                    nodes[i].right = nodes[rightIndex];
                }
            }
        }

        return nodes[0];
    }

    public static int getLCA(TreeNode root, int a, int b) {
        lca = null;
        foundA = false;
        foundB = false;

        findLCA(root, a, b);

        if (!foundA || !foundB) {
            return -1;
        }

        return lca != null ? lca.val : -1;
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

            TreeNode root = buildTree(tree);

            System.out.println(getLCA(root, a, b));
        }

        sc.close();
    }
}

