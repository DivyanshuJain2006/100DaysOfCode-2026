class Solution {

    boolean foundA = false;
    boolean foundB = false;

    public int lowestCommonAncestor(TreeNode root, int a, int b) {
        TreeNode x = find(root, a, b);

        if (foundA && foundB)
            return x.val;

        return -1;
    }

    TreeNode find(TreeNode root, int a, int b) {
        if (root == null)
            return null;

        if (root.val == a)
            foundA = true;

        if (root.val == b)
            foundB = true;

        TreeNode l = find(root.left, a, b);
        TreeNode r = find(root.right, a, b);

        if (root.val == a || root.val == b)
            return root;

        if (l != null && r != null)
            return root;

        return l != null ? l : r;
    }
}