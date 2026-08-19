class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int l = leftHeight(root);
        int r = rightHeight(root);

        if (l == r)
            return (1 << l) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    int leftHeight(TreeNode root) {
        int h = 0;

        while (root != null) {
            h++;
            root = root.left;
        }

        return h;
    }

    int rightHeight(TreeNode root) {
        int h = 0;

        while (root != null) {
            h++;
            root = root.right;
        }

        return h;
    }
}