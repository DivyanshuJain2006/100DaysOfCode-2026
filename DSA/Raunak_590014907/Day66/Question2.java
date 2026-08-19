import java.util.*;

class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        inorder(root1, a);
        inorder(root2, b);

        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {

            int value;

            if (a.get(i) < b.get(j)) {
                value = a.get(i);
                i++;
            } else if (a.get(i) > b.get(j)) {
                value = b.get(j);
                j++;
            } else {
                // Same value → add only once
                value = a.get(i);
                i++;
                j++;
            }

            if (result.isEmpty() ||
                result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        while (i < a.size()) {
            int value = a.get(i++);

            if (result.isEmpty() ||
                result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        while (j < b.size()) {
            int value = b.get(j++);

            if (result.isEmpty() ||
                result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        return result;
    }

    private void inorder(TreeNode root, List<Integer> list) {

        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}