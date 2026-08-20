import java.util.*;

public class Question1_Leetcode {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } 
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } 
        else {

            // Node has no left child
            if (root.left == null) {
                return root.right;
            }

            // Node has no right child
            if (root.right == null) {
                return root.left;
            }

            // Node has two children
            TreeNode successor = root.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            root.val = successor.val;

            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    static TreeNode buildTree(String[] arr) {

        if (arr.length == 0 || arr[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && !arr[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(current.left);
            }

            i++;

            // Right child
            if (i < arr.length && !arr[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(current.right);
            }

            i++;
        }

        return root;
    }

    static void printLevelOrder(TreeNode root) {

        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                result.add("null");
                continue;
            }

            result.add(String.valueOf(current.val));

            queue.add(current.left);
            queue.add(current.right);
        }

        // Remove unnecessary trailing nulls
        while (!result.isEmpty()
                && result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }

        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = sc.nextLine().trim().split("\\s+");

        int key = sc.nextInt();

        TreeNode root = buildTree(arr);

        root = deleteNode(root, key);

        printLevelOrder(root);

        sc.close();
    }
}