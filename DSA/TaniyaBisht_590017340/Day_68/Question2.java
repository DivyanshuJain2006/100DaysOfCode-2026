
class FA{
    static class TreeNode {
        int val; TreeNode left; TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    static class Info {
        boolean isBST;int size; int min;int max;
        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    static int largestBST = 0;
    static Info dfs(TreeNode root) {
        if (root == null) {
            return new Info(true, 0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info left = dfs(root.left);
        Info right = dfs(root.right);
        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            int size = left.size + right.size + 1;
            largestBST = Math.max(largestBST, size);
            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);
            return new Info(true, size, min, max);
        }
        return new Info(false, 0,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        dfs(root);
        System.out.println("Largest BST Size:" + largestBST);
    }
}