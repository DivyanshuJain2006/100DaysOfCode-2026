class Solution {

    public int findLCA(int[] arr, int p, int q) {
        TreeNode root = buildTree(arr);

        if (root == null) {
            return -1;
        }

        if (!find(root, p) || !find(root, q)) {
            return -1;
        }

        TreeNode ans = lca(root, p, q);

        return ans.val;
    }

    private TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curr = queue.poll();

            if (arr[i] != -1) {
                curr.left = new TreeNode(arr[i]);
                queue.add(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                curr.right = new TreeNode(arr[i]);
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }

    private boolean find(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            return true;
        }

        return find(root.left, value) || find(root.right, value);
    }

    private TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }
}
