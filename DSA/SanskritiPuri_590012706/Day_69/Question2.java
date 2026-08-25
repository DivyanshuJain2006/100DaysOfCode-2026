class Solution {

    // Returns an array:
    // result[0] = tree containing values < K
    // result[1] = tree containing values >= K
    public TreeNode[] splitBST(TreeNode root, int K) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val < K) {
            TreeNode[] parts = splitBST(root.right, K);

            root.right = parts[0];

            return new TreeNode[]{root, parts[1]};
        } else {
            TreeNode[] parts = splitBST(root.left, K);

            root.left = parts[1];

            return new TreeNode[]{parts[0], root};
        }
    }
}
