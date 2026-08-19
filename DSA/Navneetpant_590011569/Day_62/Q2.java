class Solution {
    public int rob(TreeNode root) {
        int[] result = dfs(root);

        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

=
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);


        int dontRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // Rob current
        int rob = root.val + left[0] + right[0];

        return new int[]{dontRob, rob};
    }
}