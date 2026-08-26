class Solution {
    // Returns {rootOfLessThanK, rootOfGreaterOrEqualK}
    public String[] splitBST(TreeNode root, int K) {
        TreeNode[] parts = split(root, K);
        String left  = toPreorder(parts[0]);
        String right = toPreorder(parts[1]);
        return new String[]{left, right};
    }

    private TreeNode[] split(TreeNode root, int K) {
        if (root == null) return new TreeNode[]{null, null};

        if (root.val < K) {
            // root and its whole left subtree belong to "< K"
            TreeNode[] res = split(root.right, K); // res[0] < K, res[1] >= K
            root.right = res[0];                    // reattach the "<K" part on the right
            return new TreeNode[]{root, res[1]};
        } else {
            // root and its whole right subtree belong to ">= K"
            TreeNode[] res = split(root.left, K);   // res[0] < K, res[1] >= K
            root.left = res[1];                      // reattach the ">=K" part on the left
            return new TreeNode[]{res[0], root};
        }
    }

    private String toPreorder(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        preorderHelper(node, sb);
        return sb.length() == 0 ? "EMPTY" : sb.toString().trim();
    }

    private void preorderHelper(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append(' ');
        preorderHelper(node.left, sb);
        preorderHelper(node.right, sb);
    }
}
