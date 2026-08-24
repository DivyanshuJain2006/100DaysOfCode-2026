package Day_62;

import java.util.*;

public class d62question2_technical {
   static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static Node build(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node cur = q.poll();
            if (i < arr.length && arr[i] != -1) {
                cur.left = new Node(arr[i]);
                q.add(cur.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                cur.right = new Node(arr[i]);
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    static int[] go(Node root) {
        if (root == null) return new int[]{0, 0};
        int[] L = go(root.left), R = go(root.right);
        int rob = root.val + L[1] + R[1];
        int skip = Math.max(L[0], L[1]) + Math.max(R[0], R[1]);
        return new int[]{rob, skip};
    }

    static int solve(int[] arr) {
        Node root = build(arr);
        int[] res = go(root);
        return Math.max(res[0], res[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){ arr[i] = sc.nextInt();}
        System.out.println(solve(arr));
        sc.close();
    }}