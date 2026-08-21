class Solution {
    int maxSize = 0;

    class Info {
        boolean isBST;
        int min;
        int max;
        int size;

        Info(boolean isBST, int min, int max, int size) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        solve(root);
        return maxSize;
    }

    Info solve(TreeNode root) {
        if (root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        if (left.isBST && right.isBST &&
            left.max < root.val &&
            root.val < right.min) {

            int size = left.size + right.size + 1;

            maxSize = Math.max(maxSize, size);

            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);

            return new Info(true, min, max, size);
        }

        return new Info(false, 0, 0, 0);
    }
}
