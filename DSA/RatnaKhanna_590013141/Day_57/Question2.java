import java.util.*;

class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;

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

    // Check whether two trees are mirrors
    static boolean isMirror(TreeNode a, TreeNode b) {

        // Both empty
        if (a == null && b == null) {
            return true;
        }

        // One is empty
        if (a == null || b == null) {
            return false;
        }

        // Values must be equal
        if (a.val != b.val) {
            return false;
        }

        // Left of first ↔ Right of second
        // Right of first ↔ Left of second
        return isMirror(a.left, b.right)
            && isMirror(a.right, b.left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Size of first tree
        int n = sc.nextInt();
        int[] warehouse1 = new int[n];

        for (int i = 0; i < n; i++) {
            warehouse1[i] = sc.nextInt();
        }

        // Size of second tree
        int m = sc.nextInt();
        int[] warehouse2 = new int[m];

        for (int i = 0; i < m; i++) {
            warehouse2[i] = sc.nextInt();
        }

        TreeNode root1 = buildTree(warehouse1);
        TreeNode root2 = buildTree(warehouse2);

        if (isMirror(root1, root2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}
