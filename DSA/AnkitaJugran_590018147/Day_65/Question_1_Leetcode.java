/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int prev;
    int count = 0;
    int maxCount = 0;
    boolean first = true;

    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        // Count current value
        if (first || root.val != prev) {
            count = 1;
            prev = root.val;
            first = false;
        } else {
            count++;
        }

        // Found a new maximum
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(root.val);
        }
        // Found another mode
        else if (count == maxCount) {
            result.add(root.val);
        }

        inorder(root.right);
    }
}