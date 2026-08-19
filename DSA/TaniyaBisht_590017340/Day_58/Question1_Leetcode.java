
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
    public int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        int depth = computeDepth(root);
        if(depth == 0){
            return 1;
        }
        int lastDepth = (int) Math.pow(2, depth) - 1;
        int left = 1;
        int right = (int) Math.pow(2, depth);
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(exists(mid, depth, root)) {
                left = mid + 1;
            } 
            else {
                right = mid;
            }
        }
        return lastDepth + left;
    }
    private boolean exists(int index, int depth, TreeNode node){
        int left = 0;
        int right = (int) Math.pow(2, depth) - 1;
        for (int i = 0; i < depth; i++) {
            int mid = left + (right - left) / 2;
            if (index <= mid) {
                node =node.left;
                right = mid;
            } 
            else {
                node = node.right;
                left = mid + 1;
            }
            if(node == null) {
                return false;
            }
        }
        return true;
    }
    private int computeDepth(TreeNode root) {
        int depth = 0;
        while(root.left != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
}