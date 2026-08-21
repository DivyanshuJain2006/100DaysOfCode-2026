class Solution {
    ArrayList<Integer> a = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return build(0, a.size() - 1);
    }

    void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        a.add(root.val);
        inorder(root.right);
    }

    TreeNode build(int l, int r) {
        if (l > r)
            return null;

        int m = (l + r) / 2;

        TreeNode root = new TreeNode(a.get(m));

        root.left = build(l, m - 1);
        root.right = build(m + 1, r);

        return root;
    }
}