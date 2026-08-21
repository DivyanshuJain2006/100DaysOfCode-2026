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

    static List<Integer> values = new ArrayList<>();

    static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        values.add(root.val);
        inorder(root.right);
    }

    static TreeNode buildBalancedTree(int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(values.get(mid));

        root.left = buildBalancedTree(left, mid - 1);
        root.right = buildBalancedTree(mid + 1, right);

        return root;
    }

    static TreeNode balanceBST(TreeNode root) {

        values.clear();

        inorder(root);

        return buildBalancedTree(0, values.size() - 1);
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

        TreeNode root = buildTree(arr);

        TreeNode balancedRoot = balanceBST(root);

        printLevelOrder(balancedRoot);

        sc.close();
    }
}