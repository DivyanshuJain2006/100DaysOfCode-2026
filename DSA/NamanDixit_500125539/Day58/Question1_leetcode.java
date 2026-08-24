class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int countNodes(TreeNode root) {

        // Empty tree
        if (root == null) {
            return 0;
        }

        // Find left height
        int leftHeight = 0;
        TreeNode temp = root;

        while (temp != null) {
            leftHeight++;
            temp = temp.left;
        }

        // Find right height
        int rightHeight = 0;
        temp = root;

        while (temp != null) {
            rightHeight++;
            temp = temp.right;
        }

        // Perfect binary tree
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        // Otherwise count left + right + current node
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}