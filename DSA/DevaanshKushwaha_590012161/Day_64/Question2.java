class Solution {
    public int lowestCommonAncestor(TreeNode root, int a, int b) {
        TreeNode node = root;
        
        while (node != null) {
            if (a < node.val && b < node.val) {
                // Both values are smaller, LCA is in left subtree
                node = node.left;
            } else if (a > node.val && b > node.val) {
                // Both values are larger, LCA is in right subtree
                node = node.right;
            } else {
                // Split point found (or node.val == a or node.val == b)
                return node.val;
            }
        }
        
        return -1; // Should not happen if a and b are guaranteed to exist in tree
    }
}
