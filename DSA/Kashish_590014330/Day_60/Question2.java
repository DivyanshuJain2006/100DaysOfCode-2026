import java.util.*;

public class Question2 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int countSafe(Node root) {
        if (root == null) return 0;

        int count = 0;
        Queue<Node> nodeQueue = new LinkedList<>();
        Queue<Integer> maxQueue = new LinkedList<>();

        nodeQueue.offer(root);
        maxQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            Node current = nodeQueue.poll();
            int maxSoFar = maxQueue.poll();
            if (current.val >= maxSoFar) {
                count++;
            }

            int newMax = Math.max(maxSoFar, current.val);

            if (current.left != null) {
                nodeQueue.offer(current.left);
                maxQueue.offer(newMax);
            }

            if (current.right != null) {
                nodeQueue.offer(current.right);
                maxQueue.offer(newMax);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] tree = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        if (n == 0 || tree[0] == -1) {
            System.out.println(0);
            return;
        }
        Node root = new Node(tree[0]);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < n) {
            Node current = queue.poll();
            if (i < n && tree[i] != -1) {
                current.left = new Node(tree[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < n && tree[i] != -1) {
                current.right = new Node(tree[i]);
                queue.offer(current.right);
            }
            i++;
        }

        System.out.println(countSafe(root));
    }
}
