import java.util.*;

public class Main {

    static int minusOne = 0;
    static int zero = 0;
    static int plusOne = 0;

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node buildTree(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }

        // Left-middle is automatically selected
        int mid = (left + right) / 2;

        Node root = new Node(arr[mid]);

        root.left = buildTree(arr, left, mid - 1);
        root.right = buildTree(arr, mid + 1, right);

        return root;
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    static void countBalance(Node root) {
        if (root == null) {
            return;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int balance = rightHeight - leftHeight;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr, 0, n - 1);

        countBalance(root);

        System.out.println(minusOne + " " + zero + " " + plusOne);

        sc.close();
    }
}
