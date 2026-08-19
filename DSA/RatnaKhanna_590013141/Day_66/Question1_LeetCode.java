class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        // If we reach an empty position,
        // create the new node here.
        if (root == null) {
            return new TreeNode(val);
        }

        // If val is smaller, insert into left subtree
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        // If val is greater, insert into right subtree
        else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
