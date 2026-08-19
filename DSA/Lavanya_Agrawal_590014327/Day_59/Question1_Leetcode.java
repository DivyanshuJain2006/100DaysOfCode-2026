import java.util.*;

public class Question1_Leetcode {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean nullFound = false;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                nullFound = true;
            } else {
                if (nullFound)
                    return false;

                q.add(node.left);
                q.add(node.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        if (arr[0] == -1) {
            System.out.println(false);
            return;
        }

        TreeNode[] nodes = new TreeNode[n];

        for (int i = 0; i < n; i++) {
            if (arr[i] != -1)
                nodes[i] = new TreeNode(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (left < n)
                    nodes[i].left = nodes[left];

                if (right < n)
                    nodes[i].right = nodes[right];
            }
        }

        System.out.println(isCompleteTree(nodes[0]));
    }
}