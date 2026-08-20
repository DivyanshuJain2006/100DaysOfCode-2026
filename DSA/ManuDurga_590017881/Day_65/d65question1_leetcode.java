package Day_65;

import java.util.*;

public class d65question1_leetcode {
    List<Integer> modes = new ArrayList<>();
    Integer prev = null;
    int count = 0, maxCount = 0;

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] ans = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) ans[i] = modes.get(i);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev == null || root.val != prev) count = 1;
        else count++;

        if (count > maxCount) {
            maxCount = count;
            modes.clear();
            modes.add(root.val);
        } else if (count == maxCount) {
            modes.add(root.val);
        }

        prev = root.val;
        inorder(root.right);
    }
}
