import java.util.*;

class Main {

    // BST Node
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Insert value into BST
    static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Inorder traversal
    static void inorder(TreeNode root, TreeSet<Integer> set) {
        if (root == null) {
            return;
        }

        inorder(root.left, set);
        set.add(root.val);
        inorder(root.right, set);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of nodes in first tree
        int n1 = sc.nextInt();

        TreeNode tree1 = null;

        // Input values of first tree
        for (int i = 0; i < n1; i++) {
            int value = sc.nextInt();
            tree1 = insert(tree1, value);
        }

        // Input number of nodes in second tree
        int n2 = sc.nextInt();

        TreeNode tree2 = null;

        // Input values of second tree
        for (int i = 0; i < n2; i++) {
            int value = sc.nextInt();
            tree2 = insert(tree2, value);
        }

        // TreeSet = sorted + unique
        TreeSet<Integer> result = new TreeSet<>();

        inorder(tree1, result);
        inorder(tree2, result);

        // Print result
        System.out.println(result);

        sc.close();
    }
}
