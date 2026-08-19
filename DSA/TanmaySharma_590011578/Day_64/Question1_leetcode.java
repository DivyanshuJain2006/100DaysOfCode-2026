
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
class solution{
    public int rangeSumBST(TreeNode root, int low, int high) {

    if (root == null) {
        return 0;
    }

    if (root.val < low) {
        return rangeSumBST(root.right, low, high);
    }

    if (root.val > high) {
        return rangeSumBST(root.left, low, high);
    }

    return root.val
        + rangeSumBST(root.left, low, high)
        + rangeSumBST(root.right, low, high);
}
}