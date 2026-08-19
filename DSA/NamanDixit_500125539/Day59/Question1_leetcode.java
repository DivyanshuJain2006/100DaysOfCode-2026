
class Question1_leetcode {

    public boolean isCompleteTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean seenNull = false;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                seenNull = true;
            } else {
                if (seenNull) {
                    return false;
                }
                queue.add(current.left);
                queue.add(current.right);
            }
        }

        return true;
    }
}
