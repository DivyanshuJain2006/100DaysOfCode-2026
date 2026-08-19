class Solution {
    public int rob(TreeNode root) {
        int[] x = dfs(root);
        return Math.max(x[0], x[1]);
    }

    int[] dfs(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };

        int[] l = dfs(root.left);
        int[] r = dfs(root.right);

        int rob = root.val + l[1] + r[1];

        int skip = Math.max(l[0], l[1]) +
                Math.max(r[0], r[1]);

        return new int[] { rob, skip };
    }
}