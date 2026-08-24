import java.util.*;

class Question2 {

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
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode current = q.poll();
            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                q.offer(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                q.offer(current.right);
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

        return a.val == b.val
                && isMirror(a.left, b.right)
                && isMirror(a.right, b.left);
    }

    public static void main(String[] args) {

        int[] warehouse1 = {1, 2, 3};
        int[] warehouse2 = {1, 3, 2};

        TreeNode root1 = buildTree(warehouse1);
        TreeNode root2 = buildTree(warehouse2);

        if (isMirror(root1, root2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}