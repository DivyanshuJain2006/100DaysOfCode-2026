class Solution {
    List<Integer> a = new ArrayList<>();
    void f(TreeNode r) {
        if (r == null) return;
        f(r.left); a.add(r.val); f(r.right);
    }
    TreeNode g(int l, int r) {
        if (l > r) return null;
        int m = (l + r) >> 1;
        TreeNode n = new TreeNode(a.get(m));
        n.left = g(l, m - 1);
        n.right = g(m + 1, r);
        return n;
    }

    public TreeNode balanceBST(TreeNode r) {
        f(r); return g(0, a.size() - 1);
    }
}