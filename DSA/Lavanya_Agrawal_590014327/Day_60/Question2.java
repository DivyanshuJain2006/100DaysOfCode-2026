import java.util.*;

public class Question2 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int countSafeNodes(Node root, int max) {
        if (root == null)
            return 0;

        int count = 0;

        if (root.val >= max) {
            count = 1;
            max = root.val;
        }

        count += countSafeNodes(root.left, max);
        count += countSafeNodes(root.right, max);

        return count;
    }

    static Node buildTree(int[] a) {
        if (a.length == 0 || a[0] == -1)
            return null;

        Node root = new Node(a[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < a.length) {
            Node curr = q.poll();

            if (a[i] != -1) {
                curr.left = new Node(a[i]);
                q.add(curr.left);
            }
            i++;

            if (i < a.length && a[i] != -1) {
                curr.right = new Node(a[i]);
                q.add(curr.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] tree = new int[n];

        for (int i = 0; i < n; i++)
            tree[i] = sc.nextInt();

        Node root = buildTree(tree);

        System.out.println(countSafeNodes(root, Integer.MIN_VALUE));
    }
}