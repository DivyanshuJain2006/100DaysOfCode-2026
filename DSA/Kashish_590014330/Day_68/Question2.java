import java.util.*;

class Solution {

    static class Info {
        boolean isBST;
        long min;
        long max;
        int size;

        Info(boolean isBST, long min, long max, int size) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    static int largestBST = 0;

    public static int largestBST(int[] tree) {
        largestBST = 0;

        if (tree == null || tree.length == 0 || tree[0] == -1)
            return 0;

        return solve(tree, 0).size;
    }

    static Info solve(int[] tree, int index) {

        if (index >= tree.length || tree[index] == -1) {
            return new Info(true, Long.MAX_VALUE, Long.MIN_VALUE, 0);
        }

        Info left = solve(tree, 2 * index + 1);
        Info right = solve(tree, 2 * index + 2);

        int value = tree[index];
        if (left.isBST && right.isBST &&
            left.max < value && value < right.min) {

            int size = left.size + right.size + 1;

            largestBST = Math.max(largestBST, size);

            long min = Math.min(value, left.min);
            long max = Math.max(value, right.max);

            return new Info(true, min, max, size);
        }

        return new Info(false, Long.MIN_VALUE, Long.MAX_VALUE, 0);
    }
}