class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        // If we reach an empty position,
        // insert the new node here
        if (root == null) {
            return new TreeNode(val);
        }

        // If val is smaller, go to the left subtree
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        
        // If val is larger, go to the right subtree
        else {
            root.right = insertIntoBST(root.right, val);
        }

        // Return the original root
        return root;
    }
}