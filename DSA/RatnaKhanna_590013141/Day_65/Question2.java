import java.util.*;

class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build tree from level-order input
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

    static int closestValue(TreeNode root, int target) {
        int closest = root.val;

        while (root != null) {

            // If exact target is found
            if (root.val == target) {
                return root.val;
            }

            // Update closest value
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }
            // Tie: choose smaller value
            else if (Math.abs(root.val - target) == Math.abs(closest - target)
                    && root.val < closest) {
                closest = root.val;
            }

            // Use BST property
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        TreeNode root = buildTree(arr);

        System.out.println(closestValue(root, target));

        sc.close();
    }
}
