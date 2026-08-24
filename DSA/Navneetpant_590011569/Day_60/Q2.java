class Q2 {
    int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if (root.val >= max) {
            count++;
            max = root.val;
        }

        dfs(root.left, max);
        dfs(root.right, max);
    }
}