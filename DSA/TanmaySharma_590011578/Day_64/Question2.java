

public class Question2 {

    static TreeNode lowestCommonAncestor(TreeNode root, int a, int b) {
        while (root != null) {
            if (a < root.val && b < root.val) {
                root = root.left;
            } else if (a > root.val && b > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        int a = 2;
        int b = 8;

        TreeNode result = lowestCommonAncestor(root, a, b);

        System.out.println(result.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}