class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        // If the tree/subtree is empty,
        // create a new node here.
        if (root == null) {
            return new TreeNode(val);
        }

        // Insert into left subtree
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        // Insert into right subtree
        else {
            root.right = insertIntoBST(root.right, val);
        }

        // Return the root of the BST
        return root;
    }
}