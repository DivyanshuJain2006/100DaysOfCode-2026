import java.util.*;

public class Main {

    static class Node {
        long val;
        Node left, right;

        Node(long val) {
            this.val = val;
        }
    }

    static class Info {
        boolean isBST;
        int size;
        long min;
        long max;

        Info(boolean isBST, int size, long min, long max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int maxBST = 0;

    static Info checkBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Long.MAX_VALUE, Long.MIN_VALUE);
        }

        Info left = checkBST(root.left);
        Info right = checkBST(root.right);

        // Check whether current subtree is a BST
        if (left.isBST && right.isBST &&
            root.val > left.max &&
            root.val < right.min) {

            int size = left.size + right.size + 1;

            maxBST = Math.max(maxBST, size);

            long min = Math.min(root.val, left.min);
            long max = Math.max(root.val, right.max);

            return new Info(true, size, min, max);
        }

        // Current subtree is not a BST
        return new Info(false, 0, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static Node buildTree(long[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Node[] nodes = new Node[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                nodes[i] = new Node(arr[i]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (nodes[i] == null) {
                continue;
            }

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length) {
                nodes[i].left = nodes[left];
            }

            if (right < arr.length) {
                nodes[i].right = nodes[right];
            }
        }

        return nodes[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long[] tree = new long[n];

            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextLong();
            }

            Node root = buildTree(tree);

            maxBST = 0;

            checkBST(root);

            System.out.println(maxBST);
        }

        sc.close();
    }
}
