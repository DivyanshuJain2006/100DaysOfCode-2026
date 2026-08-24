package Day_68;

import java.util.*;

public class d68question2_technical {
    static class Node {
        long val;
        Node left, right;
        Node(long v) { val = v; }
    }

    static class Info {
        boolean ok;
        int size;
        long min, max;
        Info(boolean ok, int size, long min, long max) {
            this.ok = ok; this.size = size; this.min = min; this.max = max;
        }
    }

    static int best;

    static Info dfs(Node root) {
        if (root == null) return new Info(true, 0, Long.MAX_VALUE, Long.MIN_VALUE);
        Info L = dfs(root.left), R = dfs(root.right);
        if (L.ok && R.ok && root.val > L.max && root.val < R.min) {
            int sz = L.size + R.size + 1;
            best = Math.max(best, sz);
            return new Info(true, sz, Math.min(root.val, L.min), Math.max(root.val, R.max));
        }
        return new Info(false, 0, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static Node build(long[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) if (arr[i] != -1) nodes[i] = new Node(arr[i]);
        for (int i = 0; i < arr.length; i++) {
            if (nodes[i] == null) continue;
            int l = 2*i+1, r = 2*i+2;
            if (l < arr.length) nodes[i].left = nodes[l];
            if (r < arr.length) nodes[i].right = nodes[r];
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextLong();
            Node root = build(arr);
            best = 0;
            dfs(root);
            System.out.println(best);
        }
        sc.close();
    }
}
