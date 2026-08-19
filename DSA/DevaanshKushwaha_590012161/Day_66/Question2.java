import java.util.*;

class Solution {
    public List<Integer> mergeUniqueSorted(TreeNode tree1, TreeNode tree2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(tree1, list1);
        inorder(tree2, list2);

        return mergeAndDedup(list1, list2);
    }

    // Standard in-order traversal: left -> node -> right gives sorted output for a BST
    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    // Two-pointer merge of two sorted lists, skipping duplicate values
    private List<Integer> mergeAndDedup(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            int a = list1.get(i);
            int b = list2.get(j);

            if (a < b) {
                addIfNotDuplicate(merged, a);
                i++;
            } else if (a > b) {
                addIfNotDuplicate(merged, b);
                j++;
            } else { // a == b, value appears in both trees — add once
                addIfNotDuplicate(merged, a);
                i++;
                j++;
            }
        }

        // Drain any remaining elements
        while (i < list1.size()) addIfNotDuplicate(merged, list1.get(i++));
        while (j < list2.size()) addIfNotDuplicate(merged, list2.get(j++));

        return merged;
    }

    // Since each source list is already unique internally (BST values are unique
    // within a tree), we only need to guard against the last-added value repeating
    // when merging across the two lists.
    private void addIfNotDuplicate(List<Integer> merged, int val) {
        if (merged.isEmpty() || merged.get(merged.size() - 1) != val) {
            merged.add(val);
        }
    }
}
