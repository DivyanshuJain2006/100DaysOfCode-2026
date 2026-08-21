//Need to find all values that appear most often in the BST

import java.util.*;

class Solution {

    HashMap<Integer, Integer> freq = new HashMap<>();
    int maxFreq = 0;

    public int[] findMode(TreeNode root) {

        count(root);

        ArrayList<Integer> result = new ArrayList<>();

        for (int value : freq.keySet()) {
            if (freq.get(value) == maxFreq) {
                result.add(value);
            }
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private void count(TreeNode root)
    {
        if (root == null)
            return;

        int f = freq.getOrDefault(root.val, 0) + 1;
        freq.put(root.val, f);
        maxFreq = Math.max(maxFreq, f);

        count(root.left);
        count(root.right);
    }
}
