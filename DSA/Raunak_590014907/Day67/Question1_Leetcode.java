class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        // Key not found
        if (root == null) {
            return null;
        }

        // Search left
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // Search right
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Node found
        else {

            // No left child
            if (root.left == null) {
                return root.right;
            }

            // No right child
            if (root.right == null) {
                return root.left;
            }

            // Two children
            TreeNode successor = root.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            root.val = successor.val;

            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }
}