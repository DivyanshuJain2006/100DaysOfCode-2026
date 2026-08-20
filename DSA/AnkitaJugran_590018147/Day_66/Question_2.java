import java.util.*;

public class CoporateManager {

    // Node of the BST
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build tree from compact level-order representation
    static TreeNode buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Inorder traversal of BST
    // gives values in sorted order
    static void inorder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        inorder(root.left, list);

        list.add(root.val);

        inorder(root.right, list);
    }

    // Merge two sorted lists and remove duplicates
    static List<Integer> merge(List<Integer> list1, List<Integer> list2) {

        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {

            int value;

            if (list1.get(i) < list2.get(j)) {
                value = list1.get(i);
                i++;
            }
            else if (list1.get(i) > list2.get(j)) {
                value = list2.get(j);
                j++;
            }
            else {
                // Same value exists in both trees
                value = list1.get(i);
                i++;
                j++;
            }

            // Avoid duplicates
            if (result.isEmpty() ||
                result.get(result.size() - 1) != value) {

                result.add(value);
            }
        }

        // Remaining values from list1
        while (i < list1.size()) {

            int value = list1.get(i);

            if (result.isEmpty() ||
                result.get(result.size() - 1) != value) {

                result.add(value);
            }

            i++;
        }

        // Remaining values from list2
        while (j < list2.size()) {

            int value = list2.get(j);

            if (result.isEmpty() ||
                result.get(result.size() - 1) != value) {

                result.add(value);
            }

            j++;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of test cases
        int t = sc.nextInt();

        while (t-- > 0) {

            // Read first tree
            int n1 = sc.nextInt();

            int[] tree1Array = new int[n1];

            for (int i = 0; i < n1; i++) {
                tree1Array[i] = sc.nextInt();
            }

            // Read second tree
            int n2 = sc.nextInt();

            int[] tree2Array = new int[n2];

            for (int i = 0; i < n2; i++) {
                tree2Array[i] = sc.nextInt();
            }

            // Build both BSTs
            TreeNode root1 = buildTree(tree1Array);
            TreeNode root2 = buildTree(tree2Array);

            // Inorder traversal
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            inorder(root1, list1);
            inorder(root2, list2);

            // Merge sorted lists
            List<Integer> result = merge(list1, list2);

            // Print result
            System.out.println(result);
        }

        sc.close();
    }
}