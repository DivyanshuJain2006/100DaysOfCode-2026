
import java.util.*;

public class Question1_Leetcode {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
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

            if (i < arr.length && !arr[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(current.left);
            }

            i++;

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
        while (!result.isEmpty() &&
               result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }

        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = sc.nextLine().trim().split("\\s+");

        int val = sc.nextInt();

        TreeNode root = buildTree(arr);

        root = insertIntoBST(root, val);

        printLevelOrder(root);

        sc.close();
    }
}