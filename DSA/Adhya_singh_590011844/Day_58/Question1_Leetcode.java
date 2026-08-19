class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        if (left == right) {
            return (1 << left) + countNodes(root.right);
        }

        return (1 << right) + countNodes(root.left);
    }

    private int height(TreeNode node) {
        int h = 0;

        while (node != null) {
            h++;
            node = node.left;
        }

        return h;
    }
}