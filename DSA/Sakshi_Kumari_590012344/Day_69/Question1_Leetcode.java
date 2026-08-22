class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }

        return root;
    }

    private void insert(TreeNode root, int value) {
        if (value < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(value);
            } else {
                insert(root.left, value);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(value);
            } else {
                insert(root.right, value);
            }
        }
    }
}
