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
    public boolean isCompleteTree(TreeNode root) {

        Queue <TreeNode> pq = new LinkedList <> ();
        boolean foundNull = false;

        pq.offer(root);

        while (!pq.isEmpty()) {
            TreeNode current = pq.poll();

            if (current == null) {
                foundNull = true;

            }
            else {
                if (foundNull) {
                    return false;
                }

                pq.offer(current.left);
                pq.offer(current.right);
            }
            
        }
        return true;
        


        
    }
}