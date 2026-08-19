class Solution {
    public int rob(TreeNode root) {
        int[] result = solve(root);

        // result[0] = maximum if we do NOT rob root
        // result[1] = maximum if we DO rob root
        return Math.max(result[0], result[1]);
    }

    private int[] solve(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        // If we don't rob current house,
        // we can either rob or skip each child.
        int notRob = Math.max(left[0], left[1])
                   + Math.max(right[0], right[1]);

        // If we rob current house,
        // we cannot rob either child.
        int rob = root.val + left[0] + right[0];

        return new int[]{notRob, rob};
    }
}
