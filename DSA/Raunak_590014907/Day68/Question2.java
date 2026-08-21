class Solution {

    int maxSize = 0;

    public int largestBSTSubtree(TreeNode root) {
        check(root);
        return maxSize;
    }

    private int[] check(TreeNode root) {

        // {isBST, min, max, size}
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = check(root.left);
        int[] right = check(root.right);

        // Check if current subtree is a BST
        if (left[0] == 1 &&
            right[0] == 1 &&
            root.val > left[2] &&
            root.val < right[1]) {

            int size = left[3] + right[3] + 1;

            maxSize = Math.max(maxSize, size);

            int min = Math.min(root.val, left[1]);
            int max = Math.max(root.val, right[2]);

            return new int[]{1, min, max, size};
        }

        // Not a BST
        return new int[]{0, 0, 0, 0};
    }
}