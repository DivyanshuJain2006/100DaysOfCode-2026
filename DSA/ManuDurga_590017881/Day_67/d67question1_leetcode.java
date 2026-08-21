package Day_67;

import java.util.*;

public class d67question1_leetcode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode succ = min(root.right);
            root.val = succ.val;
            root.right = deleteNode(root.right, succ.val);
        }
        return root;
    }

    private TreeNode min(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
