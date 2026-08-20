//Need to check if the tree is complete

import java.util.*;

class Solution {

    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean seenNull = false;

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node == null) {
                seenNull = true;
            } else {

                // once a gap appears, no more real nodes can come later
                if (seenNull) {
                    return false;
                }

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }
}
