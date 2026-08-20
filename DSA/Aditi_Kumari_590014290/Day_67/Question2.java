package Day_67;

public class Question2 {
    int minusOne = 0;
    int zero = 0;
    int plusOne = 0;

    public int[] balanceSpectrum(int[] arr) {
        Node root = build(arr, 0, arr.length - 1);
        calculate(root);
        return new int[]{minusOne, zero, plusOne};
    }

    private Node build(int[] arr, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        Node root = new Node(arr[mid]);
        root.left = build(arr, left, mid - 1);
        root.right = build(arr, mid + 1, right);
        return root;
    }

    private int calculate(Node root) {
        if (root == null) return 0;
        int leftHeight = calculate(root.left);
        int rightHeight = calculate(root.right);
        int balance = leftHeight - rightHeight;
        if (balance == -1) minusOne++;
        else if (balance == 0) zero++;
        else if (balance == 1) plusOne++;
        return Math.max(leftHeight, rightHeight) + 1;
    }
    class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }
}
