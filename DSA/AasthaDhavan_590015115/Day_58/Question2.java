class Question2 {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int lowestCommonAncestor(TreeNode root, int a, int b) {
        if (!exists(root, a) || !exists(root, b)) {
            return -1;
        }

        TreeNode lca = findLCA(root, a, b);
        return lca.val;
    }

    private TreeNode findLCA(TreeNode root, int a, int b) {
        if (root == null || root.val == a || root.val == b) {
            return root;
        }

        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }

    private boolean exists(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            return true;
        }

        return exists(root.left, value) || exists(root.right, value);
    }
}