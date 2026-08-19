import java.util.*;

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean foundNull = false;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                foundNull = true;
            } else {
              
                if (foundNull) {
                    return false;
                }

                q.offer(curr.left);
                q.offer(curr.right);
            }
        }

        return true;
    }
}
