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
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        
        int[] arr = values.stream().mapToInt(i -> i).toArray();
        return buildBalanced(arr, 0, arr.length - 1);
    }
    
    private void inorder(TreeNode node, List<Integer> values) {
        if (node == null) return;
        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }
    
    
    private TreeNode buildBalanced(int[] arr, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;  
        TreeNode node = new TreeNode(arr[mid]);
        node.left = buildBalanced(arr, left, mid - 1);
        node.right = buildBalanced(arr, mid + 1, right);
        return node;
    }
}