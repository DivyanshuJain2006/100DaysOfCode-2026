public class Question1_Leetcode {
    List<TreeNode> nodes = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return build(0, nodes.size() - 1);
    }
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        nodes.add(node);
        inorder(node.right);
    }
    private TreeNode build(int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = nodes.get(mid);
        root.left = build(l, mid - 1);
        root.right = build(mid + 1, r);
        return root;
    }
}