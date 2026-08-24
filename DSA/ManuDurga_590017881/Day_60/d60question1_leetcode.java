package Day_60;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class d60question1_leetcode {
    int dia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return dia;
    }

    int height(TreeNode node) {
        if (node == null) return 0;

        int l = height(node.left);
        int r = height(node.right);

        dia = Math.max(dia, l + r);
        return Math.max(l, r) + 1;
    }
}
