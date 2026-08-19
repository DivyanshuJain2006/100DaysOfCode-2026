import java.util.*;

class Solution {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int countSafeCampsites(int n, int[] tree) {

        if (n == 0 || tree.length == 0 || tree[0] == -1) {
            return 0;
        }

        // Build the binary tree from level-order array
        TreeNode root = new TreeNode(tree[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty() && index < n) {

            TreeNode current = queue.poll();

            // Left child
            if (index < n && tree[index] != -1) {
                current.left = new TreeNode(tree[index]);
                queue.offer(current.left);
            }
            index++;

            // Right child
            if (index < n && tree[index] != -1) {
                current.right = new TreeNode(tree[index]);
                queue.offer(current.right);
            }
            index++;
        }

        // DFS to count safe campsites
        return countSafe(root, Integer.MIN_VALUE);
    }

    private int countSafe(TreeNode node, int maxAltitude) {

        if (node == null) {
            return 0;
        }

        // Current node is safe if its altitude
        // is >= maximum altitude encountered above it
        int count = 0;

        if (node.val >= maxAltitude) {
            count = 1;
        }

        // Update maximum altitude for children
        int newMax = Math.max(maxAltitude, node.val);

        count += countSafe(node.left, newMax);
        count += countSafe(node.right, newMax);

        return count;
    }
}