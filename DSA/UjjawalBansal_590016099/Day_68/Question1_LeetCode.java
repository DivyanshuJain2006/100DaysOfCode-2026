class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sorted = new ArrayList<>();
        inOrderTraversal(root, sorted);
        return buildBalancedBST(sorted, 0, sorted.size() - 1);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, list);
        list.add(node.val);
        inOrderTraversal(node.right, list);
    }

    private TreeNode buildBalancedBST(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = buildBalancedBST(list, start, mid - 1);
        node.right = buildBalancedBST(list, mid + 1, end);
        return node;
    }
}