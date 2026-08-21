public class Question1_Leetcode {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null, node = root;
        while (node != null && node.val != key) {
            parent = node;
            node = key < node.val ? node.left : node.right;
        }
        if (node == null) return root;
        if (node.left == null || node.right == null) {
            TreeNode child = node.left != null ? node.left : node.right;
            if (parent == null) return child;
            if (parent.left == node) parent.left = child;
            else parent.right = child;
            return root;
        }
        TreeNode succParent = node;
        TreeNode successor = node.right;

        while (successor.left != null) {
            succParent = successor;
            successor = successor.left;
        }
        node.val = successor.val;

        if (succParent.left == successor)
            succParent.left = successor.right;
        else
            succParent.right = successor.right;

        return root;
    }
}