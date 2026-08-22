
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Pair {
    TreeNode left;
    TreeNode right;

    Pair(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}

public class SplitBST {

    static Pair split(TreeNode root, int K) {

        if (root == null) {
            return new Pair(null, null);
        }

        // root belongs to Branch A
        if (root.val < K) {

            Pair p = split(root.right, K);

            root.right = p.left;

            return new Pair(root, p.right);
        }

        // root belongs to Branch B
        else {

            Pair p = split(root.left, K);

            root.left = p.right;

            return new Pair(p.left, root);
        }
    }

    static void preorder(TreeNode root, StringBuilder result) {

        if (root == null) {
            return;
        }

        result.append(root.val).append(" ");

        preorder(root.left, result);
        preorder(root.right, result);
    }

    static void printTree(TreeNode root) {

        if (root == null) {
            System.out.println("EMPTY");
            return;
        }

        StringBuilder result = new StringBuilder();

        preorder(root, result);

        System.out.println(result.toString().trim());
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        int K = 10;

        Pair result = split(root, K);

        printTree(result.left);
        printTree(result.right);
    }
}