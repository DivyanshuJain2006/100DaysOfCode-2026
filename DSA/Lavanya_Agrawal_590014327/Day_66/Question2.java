import java.util.*;

public class Question2 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Compact level-order construction
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

    // Inorder traversal gives sorted values for a BST
    static void inorder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    static List<Integer> corporateMerger(TreeNode root1, TreeNode root2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

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
                value = list1.get(i);
                i++;
                j++;
            }

            if (result.isEmpty() ||
                result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        while (i < list1.size()) {
            int value = list1.get(i++);

            if (result.isEmpty() ||
                result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        while (j < list2.size()) {
            int value = list2.get(j++);

            if (result.isEmpty() ||
                result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n1 = sc.nextInt();
            int[] tree1 = new int[n1];

            for (int i = 0; i < n1; i++) {
                tree1[i] = sc.nextInt();
            }

            int n2 = sc.nextInt();
            int[] tree2 = new int[n2];

            for (int i = 0; i < n2; i++) {
                tree2[i] = sc.nextInt();
            }

            TreeNode root1 = buildTree(tree1);
            TreeNode root2 = buildTree(tree2);

            List<Integer> result = corporateMerger(root1, root2);

            System.out.println(result);
        }

        sc.close();
    }
}