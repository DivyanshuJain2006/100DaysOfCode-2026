public class Question1 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int index = 0;

    public static TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return buildBST(preorder, Integer.MAX_VALUE);
    }

    public static TreeNode buildBST(int[] preorder, int upperBound) {
        if (index == preorder.length || preorder[index] > upperBound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);

        root.left = buildBST(preorder, root.val);
        root.right = buildBST(preorder, upperBound);

        return root;
    }

    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};

        TreeNode root = bstFromPreorder(preorder);

        preorderTraversal(root);
    }
}