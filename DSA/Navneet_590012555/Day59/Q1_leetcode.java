class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean nullFound = false;

        while (!q.isEmpty()) {
            TreeNode x = q.poll();

            if (x == null) {
                nullFound = true;
                continue;
            }

            if (nullFound)
                return false;

            q.offer(x.left);
            q.offer(x.right);
        }

        return true;
    }
}