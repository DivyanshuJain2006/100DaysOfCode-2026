class Solution {

    public int lowestCommonAncestor(TreeNode root, int a, int b) {

        if (root == null)
            return -1;

        // First check whether both employees exist
        if (!exists(root, a) || !exists(root, b))
            return -1;

        TreeNode ans = findLCA(root, a, b);

        return ans.val;
    }

    private boolean exists(TreeNode root, int value) {

        if (root == null)
            return false;

        if (root.val == value)
            return true;

        return exists(root.left, value) ||
               exists(root.right, value);
    }

    private TreeNode findLCA(TreeNode root, int a, int b) {

        if (root == null)
            return null;

        if (root.val == a || root.val == b)
            return root;

        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);

        // One target on each side
        if (left != null && right != null)
            return root;

        // Both targets are on one side
        if (left != null)
            return left;

        return right;
    }
}