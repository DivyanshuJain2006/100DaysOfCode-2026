import java.util.*;

class Solution {

    List<Integer> values = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return build(0, values.size() - 1);
    }

    void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        values.add(root.val);
        inorder(root.right);
    }

    TreeNode build(int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(values.get(mid));

        root.left = build(left, mid - 1);
        root.right = build(mid + 1, right);

        return root;
    }
}
