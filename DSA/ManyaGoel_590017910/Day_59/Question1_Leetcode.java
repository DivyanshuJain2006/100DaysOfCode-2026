class Question1_Leetcode {
    int count = 0;
    long max = 0;
    public boolean isCompleteTree(TreeNode root) {
        dfs(root, 0);
        return max == count - 1;
    }
    private void dfs(TreeNode node, long index) {
        if (node == null) return;
        count++;
        max = Math.max(max, index);
        dfs(node.left, 2 * index + 1);
        dfs(node.right, 2 * index + 2);
    }
}