class Solution {

    int minusOne = 0;
    int zero = 0;
    int plusOne = 0;

    public int[] balanceSpectrum(int[] arr) {

        TreeNode root = build(arr, 0, arr.length - 1);

        calculate(root);

        return new int[]{minusOne, zero, plusOne};
    }

    // Build balanced BST
    private TreeNode build(int[] arr, int left, int right) {

        if (left > right)
            return null;

        // Left-middle for even length
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = build(arr, left, mid - 1);
        root.right = build(arr, mid + 1, right);

        return root;
    }

    // Returns height and counts balance factors
    private int calculate(TreeNode root) {

        if (root == null)
            return 0;

        int leftHeight = calculate(root.left);
        int rightHeight = calculate(root.right);

        int balance = leftHeight - rightHeight;

        if (balance == -1)
            minusOne++;
        else if (balance == 0)
            zero++;
        else if (balance == 1)
            plusOne++;

        return 1 + Math.max(leftHeight, rightHeight);
    }
}