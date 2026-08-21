package Day_68;

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        return build(values, 0, values.size() - 1);
    }
    private void inorder(TreeNode root, List<Integer> values) {
        if (root == null) return;
        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }
    private TreeNode build(List<Integer> values, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = build(values, left, mid - 1);
        root.right = build(values, mid + 1, right);
        return root;
    }
}