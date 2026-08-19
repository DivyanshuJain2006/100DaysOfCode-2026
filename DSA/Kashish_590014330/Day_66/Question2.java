import java.util.*;

public class Question2 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1)
            return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (i < arr.length && !queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (i < arr.length && arr[i] != -1) {
                curr.left = new TreeNode(arr[i]);
                queue.offer(curr.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                curr.right = new TreeNode(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    static void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    static List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            int value;

            if (a.get(i) < b.get(j)) {
                value = a.get(i++);
            } else if (a.get(i) > b.get(j)) {
                value = b.get(j++);
            } else {
                value = a.get(i);
                i++;
                j++;
            }

            if (result.isEmpty() || result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        while (i < a.size()) {
            int value = a.get(i++);
            if (result.isEmpty() || result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        while (j < b.size()) {
            int value = b.get(j++);
            if (result.isEmpty() || result.get(result.size() - 1) != value) {
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

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            inorder(root1, list1);
            inorder(root2, list2);

            List<Integer> result = merge(list1, list2);

            System.out.println(result);
        }

        sc.close();
    }
}
}