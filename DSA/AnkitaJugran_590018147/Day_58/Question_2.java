import java.util.*;

class LowestCommonAncestor {

    // Tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build tree from level-order array
    static TreeNode buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Check whether employee exists
    static boolean exists(TreeNode root, int value) {

        if (root == null) {
            return false;
        }

        if (root.val == value) {
            return true;
        }

        return exists(root.left, value) ||
               exists(root.right, value);
    }

    // Find Lowest Common Ancestor
    static TreeNode findLCA(TreeNode root, int a, int b) {

        if (root == null) {
            return null;
        }

        // If current node is a or b
        if (root.val == a || root.val == b) {
            return root;
        }

        // Search in left and right subtree
        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);

        // One employee is on left and one on right
        if (left != null && right != null) {
            return root;
        }

        // If found on left
        if (left != null) {
            return left;
        }

        // If found on right
        return right;
    }

    public static void main(String[] args) {

        int[] tree = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};

        int a = 5;
        int b = 1;

        // Build the tree
        TreeNode root = buildTree(tree);

        // Check if both employees exist
        if (!exists(root, a) || !exists(root, b)) {
            System.out.println(-1);
        } else {

            TreeNode answer = findLCA(root, a, b);

            System.out.println(answer.val);
        }
    }
}