import java.util.*;

public class Question2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode[] splitBST(TreeNode root, int k) {

        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val < k) {

            TreeNode[] parts = splitBST(root.right, k);

            root.right = parts[0];

            return new TreeNode[]{root, parts[1]};
        } 
        else {

            TreeNode[] parts = splitBST(root.left, k);

            root.left = parts[1];

            return new TreeNode[]{parts[0], root};
        }
    }

    // Build tree from level-order input
    static TreeNode buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }

            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }

            i++;
        }

        return root;
    }

    static void preorder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        result.add(root.val);

        preorder(root.left, result);
        preorder(root.right, result);
    }

    static void printPreorder(TreeNode root) {

        if (root == null) {
            System.out.println("EMPTY");
            return;
        }

        List<Integer> result = new ArrayList<>();

        preorder(root, result);

        for (int i = 0; i < result.size(); i++) {

            if (i > 0) {
                System.out.print(" ");
            }

            System.out.print(result.get(i));
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        TreeNode root = buildTree(arr);

        TreeNode[] result = splitBST(root, k);

        // Branch A: values < K
        printPreorder(result[0]);

        // Branch B: values >= K
        printPreorder(result[1]);

        sc.close();
    }
}