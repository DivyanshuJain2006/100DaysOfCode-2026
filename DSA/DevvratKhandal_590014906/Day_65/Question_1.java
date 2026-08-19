import java.util.*;

class Question_1 {

    static int prev;
    static int count;
    static int maxCount;
    static boolean first;
    static ArrayList<Integer> result;

    public static int[] findMode(TreeNode root) {
        prev = 0;
        count = 0;
        maxCount = 0;
        first = true;
        result = new ArrayList<>();

        inorder(root);

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (first) {
            prev = root.val;
            count = 1;
            first = false;
        } else if (root.val == prev) {
            count++;
        } else {
            count = 1;
            prev = root.val;
        }

        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(root.val);
        } else if (count == maxCount) {
            result.add(root.val);
        }

        inorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        System.out.println("Enter node values in level order (-1 for null):");

        // Simple input for testing
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeNode root = buildTree(arr, 0);

        int[] ans = findMode(root);

        System.out.println("Mode(s) of BST:");

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }

    static TreeNode buildTree(int[] arr, int i) {

        if (i >= arr.length || arr[i] == -1)
            return null;

        TreeNode root = new TreeNode(arr[i]);

        root.left = buildTree(arr, 2 * i + 1);
        root.right = buildTree(arr, 2 * i + 2);

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}