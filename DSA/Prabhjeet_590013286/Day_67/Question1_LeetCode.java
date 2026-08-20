//Need to delete a node while keeping the BST valid

class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val)
        {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val)
        {
            root.right = deleteNode(root.right, key);
        }
        else
        {
            // node has at most one child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // find the smallest value on the right
            TreeNode successor = root.right;

            while (successor.left != null)
            {
                successor = successor.left;
            }

            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }
}
