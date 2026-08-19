class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Base case: found the empty spot — create and attach new node here
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            // Belongs in left subtree
            root.left = insertIntoBST(root.left, val);
        } else {
            // Belongs in right subtree (val > root.val, since no duplicates)
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
