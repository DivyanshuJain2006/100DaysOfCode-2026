import java.util.*;

class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
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

    static class Result {
        TreeNode lca;
        boolean foundA;
        boolean foundB;

        Result(TreeNode lca, boolean foundA, boolean foundB) {
            this.lca = lca;
            this.foundA = foundA;
            this.foundB = foundB;
        }
    }

    static Result findLCA(TreeNode root, int a, int b) {

        if (root == null) {
            return new Result(null, false, false);
        }

        Result left = findLCA(root.left, a, b);
        Result right = findLCA(root.right, a, b);

        boolean foundA = left.foundA || right.foundA || root.val == a;
        boolean foundB = left.foundB || right.foundB || root.val == b;

        TreeNode lca = null;

        if (root.val == a || root.val == b) {
            lca = root;
        }
        else if (left.lca != null && right.lca != null) {
            lca = root;
        }
        else if (left.lca != null) {
            lca = left.lca;
        }
        else if (right.lca != null) {
            lca = right.lca;
        }

        return new Result(lca, foundA, foundB);
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

            Result result = findLCA(root, a, b);

            if (result.foundA && result.foundB) {
                System.out.println(result.lca.val);
            }
            else {
                System.out.println(-1);
            }
        }

        sc.close();
    }
}