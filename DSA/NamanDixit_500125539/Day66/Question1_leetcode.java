
class Question1_leetcode {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        // If tree is empty, create a new node
        if (root == null) {
            return new TreeNode(val);
        }

        // Smaller value goes left
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } // Greater value goes right
        else {
            root.right = insertIntoBST(root.right, val);
        }

        // Return the root
        return root;
    }
}
