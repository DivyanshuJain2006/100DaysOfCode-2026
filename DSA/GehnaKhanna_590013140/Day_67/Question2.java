class Solution {

    int countMinusOne = 0;
    int countZero = 0;
    int countPlusOne = 0;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int[] balanceSpectrum(int[] arr) {

        TreeNode root = buildTree(arr, 0, arr.length - 1);

        calculateBalance(root);

        return new int[]{countMinusOne, countZero, countPlusOne};
    }

    // Build balanced BST
    private TreeNode buildTree(int[] arr, int left, int right) {

        if (left > right) {
            return null;
        }

        // Left-middle for even length
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = buildTree(arr, left, mid - 1);
        root.right = buildTree(arr, mid + 1, right);

        return root;
    }

    // Calculate height and count balance factors
    private int calculateBalance(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = calculateBalance(root.left);
        int rightHeight = calculateBalance(root.right);

        int balance = leftHeight - rightHeight;

        if (balance == -1) {
            countMinusOne++;
        }
        else if (balance == 0) {
            countZero++;
        }
        else if (balance == 1) {
            countPlusOne++;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
