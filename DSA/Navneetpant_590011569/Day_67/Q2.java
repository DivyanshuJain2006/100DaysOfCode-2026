class Solution {

    int neg = 0;
    int zero = 0;
    int pos = 0;

    public int[] solve(int[] arr) {

        TreeNode root = build(arr, 0, arr.length - 1);

        check(root);

        return new int[]{neg, zero, pos};
    }

    public TreeNode build(int[] arr, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = build(arr, left, mid - 1);
        root.right = build(arr, mid + 1, right);

        return root;
    }

    public int check(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = check(root.left);
        int right = check(root.right);

        int balance = right - left;

        if (balance == -1) {
            neg++;
        }
        else if (balance == 0) {
            zero++;
        }
        else {
            pos++;
        }

        return Math.max(left, right) + 1;
    }
}