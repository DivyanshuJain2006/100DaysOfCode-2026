class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // No left child
            if (root.left == null)
                return root.right;

            // No right child
            if (root.right == null)
                return root.left;

            // Two children
            TreeNode x = root.right;

            while (x.left != null)
                x = x.left;

            root.val = x.val;
            root.right = deleteNode(root.right, x.val);
        }

        return root;
    }
}