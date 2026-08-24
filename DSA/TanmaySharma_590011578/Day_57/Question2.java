package DSA.TanmaySharma_590011578.Day_57;
import java.util.*;

public class Question2 {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

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

            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        return a.val == b.val &&
               isMirror(a.left, b.right) &&
               isMirror(a.right, b.left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] warehouse1 = new int[n];

        for (int i = 0; i < n; i++) {
            warehouse1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] warehouse2 = new int[m];

        for (int i = 0; i < m; i++) {
            warehouse2[i] = sc.nextInt();
        }

        TreeNode tree1 = buildTree(warehouse1);
        TreeNode tree2 = buildTree(warehouse2);

        if (isMirror(tree1, tree2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}
