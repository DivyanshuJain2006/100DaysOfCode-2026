import java.util.*;

class Solution {

    int currentCount = 0;
    int maxCount = 0;
    Integer previous = null;

    List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {

        inorder(root);

        int[] result = new int[modes.size()];

        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    private void inorder(TreeNode root) {

        if (root == null)
            return;

        inorder(root.left);

        // Count current value
        if (previous != null && previous == root.val) {
            currentCount++;
        } else {
            currentCount = 1;
        }

        // New maximum frequency
        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(root.val);
        }

        // Same maximum frequency
        else if (currentCount == maxCount) {
            modes.add(root.val);
        }

        previous = root.val;

        inorder(root.right);
    }
}