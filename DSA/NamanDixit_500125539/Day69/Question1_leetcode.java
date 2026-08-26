class Question1_leetcode {

    // Index to keep track of the current element
    int index = 0;

    // Main LeetCode function
    public TreeNode bstFromPreorder(int[] preorder) {

        // Build the BST
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Build BST using a valid range
    TreeNode build(int[] preorder, int min, int max) {

        // If all elements are used
        if (index == preorder.length) {
            return null;
        }

        // Get current value
        int value = preorder[index];

        // If value is outside the allowed range,
        // it belongs to another subtree
        if (value < min || value > max) {
            return null;
        }

        // Create a new node
        TreeNode root = new TreeNode(value);

        // Move to the next element
        index++;

        // Smaller values go to the left
        root.left = build(preorder, min, value);

        // Greater values go to the right
        root.right = build(preorder, value, max);

        // Return the root
        return root;
    }
}