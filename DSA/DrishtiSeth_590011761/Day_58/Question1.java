class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == right)
            return (1 << (left + 1)) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getHeight(TreeNode root) {
        int h = 0;

        while (root != null) {
            h++;
            root = root.left;
        }

        return h;
    }
}
