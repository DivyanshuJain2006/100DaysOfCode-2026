import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean seenNull = false;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node == null) {
                seenNull = true;
            } else {
                if (seenNull) {
                    // found a non-null node after a null one -> gap exists
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        
        return true;
    }
}
