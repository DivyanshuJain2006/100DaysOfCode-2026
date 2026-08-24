package Day_68;

public class Question2 {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int maxSize = 0;

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int largestBST(Node root) {
        maxSize = 0;
        check(root);
        return maxSize;
    }

    private static Info check(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = check(root.left);
        Info right = check(root.right);

        if (left.isBST && right.isBST &&
            root.val > left.max && root.val < right.min) {

            int size = left.size + right.size + 1;
            maxSize = Math.max(maxSize, size);

            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);

            return new Info(true, size, min, max);
        }

        return new Info(false, 0, 0, 0);
    }
}