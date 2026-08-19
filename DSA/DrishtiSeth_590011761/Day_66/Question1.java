class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        // If tree is empty, create a new node
        if (root == null) {
            return new TreeNode(val);
        }

        // If val is smaller, go to left subtree
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        // If val is greater, go to right subtree
        else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
