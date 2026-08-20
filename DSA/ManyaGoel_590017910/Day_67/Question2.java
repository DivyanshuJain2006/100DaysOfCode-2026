import java.util.*;

public class Question2 {
    public static class TreeNode {
        int val, height;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            height = 0;
        }
    }
    public static int negative = 0, zero = 0, positive = 0;

    public static int height(TreeNode node) {
        return node == null ? -1 : node.height;
    }

    public static TreeNode buildTree(int[] arr, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) >>> 1;
        TreeNode node = new TreeNode(arr[mid]);

        node.left = buildTree(arr, left, mid - 1);
        node.right = buildTree(arr, mid + 1, right);

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        node.height = Math.max(leftHeight, rightHeight) + 1;

        int balance = rightHeight - leftHeight;

        if (balance == -1)
            negative++;
        else if (balance == 0)
            zero++;
        else
            positive++;

        return node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array: " + Arrays.toString(arr));
        buildTree(arr, 0, n - 1);

        System.out.println("Nodes with balance factor -1: " + negative);
        System.out.println("Nodes with balance factor 0: " + zero);
        System.out.println("Nodes with balance factor +1: " + positive);
        System.out.println("Output: " + negative + " " + zero + " " + positive);

        sc.close();
    }
}