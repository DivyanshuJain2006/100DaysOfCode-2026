class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        
        if (root.val < low) {
            // Whole left subtree is < low, skip it
            return rangeSumBST(root.right, low, high);
        }
        
        if (root.val > high) {
            // Whole right subtree is > high, skip it
            return rangeSumBST(root.left, low, high);
        }
        
        // root.val is within [low, high]
        return root.val 
             + rangeSumBST(root.left, low, high) 
             + rangeSumBST(root.right, low, high);
    }
}
