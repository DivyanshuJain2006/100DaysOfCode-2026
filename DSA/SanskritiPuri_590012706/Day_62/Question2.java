import java.util.*;

public class Main {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node buildTree(int[] tree) {
        if (tree.length == 0 || tree[0] == -1) {
            return null;
        }

        Node root = new Node(tree[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < tree.length) {
            Node current = queue.poll();

            if (i < tree.length && tree[i] != -1) {
                current.left = new Node(tree[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < tree.length && tree[i] != -1) {
                current.right = new Node(tree[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    static int[] solve(Node root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        // Rob current house
        int rob = root.val + left[1] + right[1];

        // Don't rob current house
        int notRob = Math.max(left[0], left[1])
                   + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }

    static int maxRobbery(int[] tree) {
        Node root = buildTree(tree);

        int[] result = solve(root);

        return Math.max(result[0], result[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] tree = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        System.out.println(maxRobbery(tree));

        sc.close();
    }
}
