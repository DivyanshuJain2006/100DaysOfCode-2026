class Solution {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }

    int height(TreeNode root) {
        if (root == null)
            return 0;

        int l = height(root.left);
        int r = height(root.right);

        ans = Math.max(ans, l + r);

        return Math.max(l, r) + 1;
    }
}