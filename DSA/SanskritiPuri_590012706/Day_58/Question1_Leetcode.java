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
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if (leftHeight == rightHeight) {
            // Left subtree is perfect: 2^leftHeight - 1 nodes in it, +1 for root
            // Recurse only on the right subtree
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            // Right subtree is perfect (one level shorter): 2^rightHeight - 1 nodes, +1 for root
            // Recurse only on the left subtree
            return (1 << rightHeight) + countNodes(root.left);
        }
    }
    
    // Returns height by always going left (works because tree is complete)
    private int getHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
}
