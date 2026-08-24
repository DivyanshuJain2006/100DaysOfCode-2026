public class Question2 {
    class Info {
        int size;
        int max;
        int min;
        boolean isBST;
        Info(int size, int max, int min, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    private int maxSize = 0;

    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return maxSize;
    }

    private Info helper(TreeNode node) {
        if (node == null) {
            return new Info(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        Info left = helper(node.left);
        Info right = helper(node.right);
        if (left.isBST && right.isBST && node.val > left.max && node.val < right.min) {
            int size = left.size + right.size + 1;
            maxSize = Math.max(maxSize, size);
            return new Info(size, Math.max(node.val, right.max), Math.min(node.val, left.min), true);
        }
        return new Info(0, 0, 0, false);
    }
}