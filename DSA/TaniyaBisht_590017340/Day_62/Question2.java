
class TH {
    static class TreeNode {
        int val; TreeNode left; TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
    private static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int robCurrent = root.val + left[1] + right[1];
        int skipCurrent =
                Math.max(left[0], left[1])+ Math.max(right[0], right[1]);
        return new int[]{robCurrent, skipCurrent};
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println("Maximum Money:" + rob(root));
    }
}