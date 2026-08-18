import java.util.*;

class Solution {
    int currentCount = 0;
    int maxCount = 0;
    Integer prev = null;

    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        
        if (prev != null && prev == root.val) {
            currentCount++;
        } else {
            currentCount = 1;
        }

        
        if (currentCount > maxCount) {
            maxCount = currentCount;
            result.clear();
            result.add(root.val);
        } 
        
        else if (currentCount == maxCount) {
            result.add(root.val);
        }

        prev = root.val;

        inorder(root.right);
    }
}