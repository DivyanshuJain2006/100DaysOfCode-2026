import java.util.*;

class Question_2 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int safeCount = 0;

    static void countSafe(TreeNode root, int maxAltitude) {
        if (root == null)
            return;

        if (root.val >= maxAltitude)
            safeCount++;

        maxAltitude = Math.max(maxAltitude, root.val);

        countSafe(root.left, maxAltitude);
        countSafe(root.right, maxAltitude);
    }

    static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1)
            return null;

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode current = q.poll();

            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                q.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                q.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter level-order tree elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeNode root = buildTree(arr);

        safeCount = 0;
        countSafe(root, Integer.MIN_VALUE);

        System.out.println("Number of safe campsites: " + safeCount);
    }
}