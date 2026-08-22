
class Question1_leetcode {

    public TreeNode balanceBST(TreeNode root) {
        // Step 1: Collect all values in sorted order using in-order traversal
        List<Integer> sortedValues = new ArrayList<>();
        inorderTraversal(root, sortedValues);

        // Step 2: Recursively build a balanced BST from the sorted list
        return buildBalancedTree(sortedValues, 0, sortedValues.size() - 1);
    }

    // Helper method to perform in-order traversal
    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    // Helper method to construct a balanced BST from the sorted list
    private TreeNode buildBalancedTree(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = buildBalancedTree(list, start, mid - 1);
        node.right = buildBalancedTree(list, mid + 1, end);

        return node;
    }
}
