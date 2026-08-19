import java.util.*;

public class Question2 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode lowestCommonAncestor(TreeNode root, int a, int b) {

        if (a < root.val && b < root.val) {
            return lowestCommonAncestor(root.left, a, b);
        }

        if (a > root.val && b > root.val) {
            return lowestCommonAncestor(root.right, a, b);
        }

        return root;
    }

    static TreeNode buildTree(String[] arr) {

        if (arr.length == 0 || arr[0].equals("null")) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("null")) {
                nodes[i] = new TreeNode(Integer.parseInt(arr[i]));
            }
        }

        for (int i = 0; i < arr.length; i++) {

            if (nodes[i] != null) {

                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (left < arr.length) {
                    nodes[i].left = nodes[left];
                }

                if (right < arr.length) {
                    nodes[i].right = nodes[right];
                }
            }
        }

        return nodes[0];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int test = 0; test < t; test++) {

            int n = sc.nextInt();
            sc.nextLine();

            String[] arr = sc.nextLine().trim().split("\\s+");

            int a = sc.nextInt();
            int b = sc.nextInt();

            TreeNode root = buildTree(arr);

            TreeNode lca = lowestCommonAncestor(root, a, b);

            System.out.println(lca.val);
        }

        sc.close();
    }
}