package DSA.TanmaySharma_590011578.Day_60;
import java.util.*;
class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        // Longest path passing through this node
        diameter = Math.max(diameter, left + right);

        // Return height of this subtree
        return 1 + Math.max(left, right);
    }
}