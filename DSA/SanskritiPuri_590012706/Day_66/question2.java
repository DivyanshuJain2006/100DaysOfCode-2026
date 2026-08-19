import java.util.*;

public class Main {

    static class Node {
        long val;
        Node left, right;

        Node(long val) {
            this.val = val;
        }
    }

    // Build tree from level-order representation
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

    // Inorder traversal
    static void inorder(Node root, List<Long> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // Merge two sorted lists and remove duplicates
    static List<Long> merge(List<Long> a, List<Long> b) {
        List<Long> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a.size() && j < b.size()) {
            long value;

            if (a.get(i) < b.get(j)) {
                value = a.get(i++);
            } else if (a.get(i) > b.get(j)) {
                value = b.get(j++);
            } else {
                value = a.get(i);
                i++;
                j++;
            }

            if (result.isEmpty() || result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        while (i < a.size()) {
            long value = a.get(i++);

            if (result.isEmpty() || result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        while (j < b.size()) {
            long value = b.get(j++);

            if (result.isEmpty() || result.get(result.size() - 1) != value) {
                result.add(value);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n1 = sc.nextInt();
            long[] tree1 = new long[n1];

            for (int i = 0; i < n1; i++) {
                tree1[i] = sc.nextLong();
            }

            int n2 = sc.nextInt();
            long[] tree2 = new long[n2];

            for (int i = 0; i < n2; i++) {
                tree2[i] = sc.nextLong();
            }

            Node root1 = buildTree(tree1);
            Node root2 = buildTree(tree2);

            List<Long> list1 = new ArrayList<>();
            List<Long> list2 = new ArrayList<>();

            inorder(root1, list1);
            inorder(root2, list2);

            List<Long> result = merge(list1, list2);

            for (int i = 0; i < result.size(); i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(result.get(i));
            }

            System.out.println();
        }

        sc.close();
    }
}
