public class Question1_LeetCode {
    public boolean isCompleteTree(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean pastNull = false;
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            if (current == null) {
                pastNull = true;
            } 
            else {
                if (pastNull) {
                    return false;
                }
                
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        return true;
    }
}
