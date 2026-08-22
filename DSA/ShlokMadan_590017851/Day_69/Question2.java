public class Question2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode[] splitBST(TreeNode root, int k) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val < k) {
            TreeNode[] split = splitBST(root.right, k);

            root.right = split[0];
            return new TreeNode[]{root, split[1]};
        } else {
            TreeNode[] split = splitBST(root.left, k);

            root.left = split[1];
            return new TreeNode[]{split[0], root};
        }
    }

    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        int k = 10;

        TreeNode[] result = splitBST(root, k);

        if (result[0] == null) {
            System.out.println("EMPTY");
        } else {
            preorder(result[0]);
            System.out.println();
        }

        if (result[1] == null) {
            System.out.println("EMPTY");
        } else {
            preorder(result[1]);
        }
    }
}