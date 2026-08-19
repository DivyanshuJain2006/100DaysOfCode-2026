import java.util.*;

class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Insert a value into BST
    static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Find Lowest Common Ancestor
    static TreeNode lowestCommonAncestor(TreeNode root, int a, int b) {

        while (root != null) {

            // Both values are smaller than root
            if (a < root.val && b < root.val) {
                root = root.left;
            }

            // Both values are greater than root
            else if (a > root.val && b > root.val) {
                root = root.right;
            }

            // Values are on different sides
            // or one of them is the current node
            else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of nodes
        int n = sc.nextInt();

        TreeNode root = null;

        // Input tree values
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insert(root, value);
        }

        // Input two nodes
        int a = sc.nextInt();
        int b = sc.nextInt();

        TreeNode ans = lowestCommonAncestor(root, a, b);

        if (ans != null) {
            System.out.println(ans.val);
        }

        sc.close();
    }
}
