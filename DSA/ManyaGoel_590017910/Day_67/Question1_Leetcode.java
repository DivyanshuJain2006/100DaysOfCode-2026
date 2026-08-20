public class Question1_Leetcode {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode nodeParent = null, node = root;
        while (node != null && node.val != key) {
            nodeParent = node;
            node = key < node.val ? node.left : node.right;
        }
        if (node == null) return root;
        if (node.left == null || node.right == null) {
            TreeNode child = node.left != null ? node.left : node.right;
            if (nodeParent == null) return child;
            if (nodeParent.left == node)
                nodeParent.left = child;
            else
                nodeParent.right = child;

            return root;
        }
        TreeNode parent = node;
        TreeNode successor = node.right;
        while (successor.left != null) {
            parent = successor;
            successor = successor.left;
        }
        node.val = successor.val;
        if (parent.left == successor) parent.left = successor.right;
        else parent.right = successor.right;
        return root;
    }
}