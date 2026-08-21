import java.util.*;

public class HeightBalanceBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build a height-balanced BST
    static TreeNode buildBST(int[] arr, int low, int high) {
        if (low > high)
            return null;

        // Left-middle element
        int mid = (low + high) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = buildBST(arr, low, mid - 1);
        root.right = buildBST(arr, mid + 1, high);

        return root;
    }

    // Returns height while counting balance factors
    static int countBalance(TreeNode root, int[] count) {
        if (root == null)
            return 0;

        int leftHeight = countBalance(root.left, count);
        int rightHeight = countBalance(root.right, count);

        int balance = leftHeight - rightHeight;

        if (balance == -1)
            count[0]++;
        else if (balance == 0)
            count[1]++;
        else if (balance == 1)
            count[2]++;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        TreeNode root = buildBST(arr, 0, n - 1);

        int[] count = new int[3];

        countBalance(root, count);

        System.out.println("[" + count[0] + ", " + count[1] + ", " + count[2] + "]");

        sc.close();
    }
}