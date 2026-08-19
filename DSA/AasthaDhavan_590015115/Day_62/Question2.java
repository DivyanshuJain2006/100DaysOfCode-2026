class Question2 {
    static int rob(TreeNode root) {
        int[] ans = solve(root);
        return Math.max(ans[0], ans[1]);
    }

    static int[] solve(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int notRob = Math.max(left[0], left[1])
                   + Math.max(right[0], right[1]);

        int rob = root.val + left[0] + right[0];

        return new int[]{notRob, rob};
    }
}