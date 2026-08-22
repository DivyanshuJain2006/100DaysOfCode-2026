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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sorted = new ArrayList<>();
        inorder(root, sorted);
        return buildBalanced(sorted, 0, sorted.size() - 1);
    }
    
    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
    
    private TreeNode buildBalanced(List<Integer> sorted, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;   // avoids overflow, picks left-biased middle
        TreeNode node = new TreeNode(sorted.get(mid));
        node.left = buildBalanced(sorted, lo, mid - 1);
        node.right = buildBalanced(sorted, mid + 1, hi);
        return node;
    }
}
