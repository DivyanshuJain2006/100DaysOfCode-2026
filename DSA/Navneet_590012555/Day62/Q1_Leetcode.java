class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null)
            return root.val == 1;

        boolean l = evaluateTree(root.left);
        boolean r = evaluateTree(root.right);

        if (root.val == 2)
            return l || r;
        else
            return l && r;
    }
}