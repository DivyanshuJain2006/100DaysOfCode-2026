import java.util.*;

public class Main {

    static class Node {
        long val;
        Node left, right;

        Node(long val) {
            this.val = val;
        }
    }

    static long closestValue(Node root, double target) {
        long closest = root.val;

        while (root != null) {

            double currentDiff = Math.abs(root.val - target);
            double closestDiff = Math.abs(closest - target);

            // Update if current is closer,
            // or equally close but smaller
            if (currentDiff < closestDiff ||
                (currentDiff == closestDiff && root.val < closest)) {
                closest = root.val;
            }

            if (target < root.val) {
                root = root.left;
            } else if (target > root.val) {
                root = root.right;
            } else {
                return root.val;
            }
        }

        return closest;
    }

    static Node buildTree(long[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Node[] nodes = new Node[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                nodes[i] = new Node(arr[i]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (nodes[i] == null) {
                continue;
            }

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length) {
                nodes[i].left = nodes[left];
            }

            if (right < arr.length) {
                nodes[i].right = nodes[right];
            }
        }

        return nodes[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            long[] tree = new long[n];

            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextLong();
            }

            double target = sc.nextDouble();

            Node root = buildTree(tree);

            System.out.println(closestValue(root, target));
        }

        sc.close();
    }
}
