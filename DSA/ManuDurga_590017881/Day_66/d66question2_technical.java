package Day_66;

import java.util.*;

public class d66question2_technical {
    static class Node {
        long val;
        Node left, right;
        Node(long v) { val = v; }
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

    static void inorder(Node root, List<Long> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    static List<Long> merge(List<Long> a, List<Long> b) {
        List<Long> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            long v;
            if (a.get(i) < b.get(j)) v = a.get(i++);
            else if (a.get(i) > b.get(j)) v = b.get(j++);
            else { v = a.get(i); i++; j++; }
            if (res.isEmpty() || res.get(res.size()-1) != v) res.add(v);
        }
        while (i < a.size()) {
            long v = a.get(i++);
            if (res.isEmpty() || res.get(res.size()-1) != v) res.add(v);
        }
        while (j < b.size()) {
            long v = b.get(j++);
            if (res.isEmpty() || res.get(res.size()-1) != v) res.add(v);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n1 = sc.nextInt();
            long[] arr1 = new long[n1];
            for (int i = 0; i < n1; i++) arr1[i] = sc.nextLong();
            int n2 = sc.nextInt();
            long[] arr2 = new long[n2];
            for (int i = 0; i < n2; i++) arr2[i] = sc.nextLong();

            List<Long> list1 = new ArrayList<>(), list2 = new ArrayList<>();
            inorder(build(arr1), list1);
            inorder(build(arr2), list2);

            List<Long> res = merge(list1, list2);
            for (int i = 0; i < res.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(res.get(i));
            }
            System.out.println();
        }
        sc.close();
    }
}

