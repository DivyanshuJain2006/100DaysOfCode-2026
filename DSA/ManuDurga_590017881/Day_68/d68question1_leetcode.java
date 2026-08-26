package Day_68;

import java.util.*;

public class d68question1_leetcode {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        return build(vals, 0, vals.size() - 1);
    }

    private void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }

    private TreeNode build(List<Integer> vals, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2; // left-middle if even
        TreeNode node = new TreeNode(vals.get(mid));
        node.left = build(vals, l, mid - 1);
        node.right = build(vals, mid + 1, r);
        return node;
    }
}
