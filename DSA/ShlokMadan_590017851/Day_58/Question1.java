public class Question1 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int countNodes(TreeNode root) {

        if(root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(leftHeight == rightHeight)
            return (1 << leftHeight) + countNodes(root.right);

        return (1 << rightHeight) + countNodes(root.left);
    }

    public static int getHeight(TreeNode root) {

        int height = 0;

        while(root != null) {
            height++;
            root = root.left;
        }

        return height;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(countNodes(root));
    }
}