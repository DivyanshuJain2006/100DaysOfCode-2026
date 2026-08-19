class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, int a, int b) {
        if (root.val > a && root.val > b)
            return lowestCommonAncestor(root.left, a, b);

        if (root.val < a && root.val < b)
            return lowestCommonAncestor(root.right, a, b);

        return root;
    }
}
