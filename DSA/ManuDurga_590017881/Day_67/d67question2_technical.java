package Day_67;

import java.util.*;

public class d67question2_technical {
   static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static Node build(int[] arr, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2; // left-middle if even
        Node root = new Node(arr[mid]);
        root.left = build(arr, l, mid - 1);
        root.right = build(arr, mid + 1, r);
        return root;
    }

    static int[] dfs(Node root, int[] count) {
        if (root == null) return new int[]{0};
        int[] L = dfs(root.left, count);
        int[] R = dfs(root.right, count);
        int hL = L[0], hR = R[0];
        int bal = hR - hL;
        if (bal == -1) count[0]++;
        else if (bal == 0) count[1]++;
        else if (bal == 1) count[2]++;
        return new int[]{1 + Math.max(hL, hR)};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Node root = build(arr, 0, n - 1);
        int[] count = new int[3]; // [-1, 0, +1]
        dfs(root, count);

        System.out.println(count[0] + " " + count[1] + " " + count[2]);
        sc.close();
    }
}

