package Day_65;

import java.util.*;

public class d65question2_technical {
    static class Node {
        long val;
        Node left, right;
        Node(long v) { val = v; }
    }

    static long closest(Node root, double target) {
        long best = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(best - target) ||
                (Math.abs(root.val - target) == Math.abs(best - target) && root.val < best)) {
                best = root.val;
            }
            root = target < root.val ? root.left : root.right;
        }
        return best;
    }

    static Node build(long[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) if (arr[i] != -1) nodes[i] = new Node(arr[i]);
        for (int i = 0; i < arr.length; i++) {
            if (nodes[i] == null) continue;
            int l = 2 * i + 1, r = 2 * i + 2;
            if (l < arr.length) nodes[i].left = nodes[l];
            if (r < arr.length) nodes[i].right = nodes[r];
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextLong();
            double target = sc.nextDouble();
            System.out.println(closest(build(arr), target));
        }
        sc.close();
    }
}
