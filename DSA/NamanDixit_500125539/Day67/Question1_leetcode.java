
class Question1_leetcode {

    // Function to delete a node from BST
    public TreeNode deleteNode(TreeNode root, int key) {

        // If tree is empty or key is not found
        if (root == null) {
            return null;
        }

        // If key is smaller, search in left subtree
        if (key < root.val) {

            root.left = deleteNode(root.left, key);
        } // If key is greater, search in right subtree
        else if (key > root.val) {

            root.right = deleteNode(root.right, key);
        } // Key is found
        else {

            // Case 1: No left child
            // Return right child
            if (root.left == null) {
                return root.right;
            }
            // Case 2: No right child
            // Return left child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Node has two children
            // Find the smallest node in right subtree
            TreeNode temp = root.right;

            while (temp.left != null) {
                temp = temp.left;
            }

            // Copy the smallest value
            // into the current node
            root.val = temp.val;

            // Delete the duplicate node
            root.right = deleteNode(root.right, temp.val);
        }

        // Return root
        return root;
    }
}
