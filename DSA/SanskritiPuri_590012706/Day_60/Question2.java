import java.util.*;

public class Main {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static class Pair {
        Node node;
        int maxAltitude;

        Pair(Node node, int maxAltitude) {
            this.node = node;
            this.maxAltitude = maxAltitude;
        }
    }

    static int countSafeCampsites(int[] tree) {
        if (tree.length == 0 || tree[0] == -1) {
            return 0;
        }

        Node root = buildTree(tree);

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, root.val));

        int count = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            Node node = current.node;
            int maxAltitude = current.maxAltitude;

            // Safe if current altitude is >= maximum
            // altitude encountered before it
            if (node.val >= maxAltitude) {
                count++;
            }

            int newMax = Math.max(maxAltitude, node.val);

            if (node.left != null) {
                queue.offer(new Pair(node.left, newMax));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, newMax));
            }
        }

        return count;
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

            // Left child
            if (i < tree.length && tree[i] != -1) {
                current.left = new Node(tree[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < tree.length && tree[i] != -1) {
                current.right = new Node(tree[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] tree = new int[n];

            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }

            System.out.println(countSafeCampsites(tree));
        }

        sc.close();
    }
}
