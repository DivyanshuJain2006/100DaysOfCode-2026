
import java.util.*;

class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {

    int minusOne = 0;
    int zero = 0;
    int plusOne = 0;

    // Build balanced BST using left-middle element
    TreeNode build(int[] arr, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = build(arr, left, mid - 1);
        root.right = build(arr, mid + 1, right);

        return root;
    }

    // Find height of tree
    int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(
                height(root.left),
                height(root.right)
        );
    }

    // Count balance factors
    void countBalance(TreeNode root) {

        if (root == null) {
            return;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int balance = leftHeight - rightHeight;

        if (balance == -1) {
            minusOne++;
        } else if (balance == 0) {
            zero++;
        } else if (balance == 1) {
            plusOne++;
        }

        countBalance(root.left);
        countBalance(root.right);
    }

    int[] balanceSpectrum(int[] arr) {

        if (arr.length == 0) {
            return new int[]{0, 0, 0};
        }

        TreeNode root = build(arr, 0, arr.length - 1);

        countBalance(root);

        return new int[]{minusOne, zero, plusOne};
    }
}

public class Question2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution solution = new Solution();

        int[] result = solution.balanceSpectrum(arr);

        System.out.println(
                "[" + result[0] + ", "
                + result[1] + ", "
                + result[2] + "]"
        );

        sc.close();
    }
}
