import java.util.*;

public class Question2 {

    static class Node {
        int val, ht;
        Node left, right;

        Node(int val) {
            this.val = val;
            ht = 0;
        }
    }
    static int neg = 0, zero = 0, pos = 0;
    static int getHeight(Node node) {
        return node == null ? -1 : node.ht;
    }
    static Node makeTree(int[] a, int l, int r) {
        if (l > r)
            return null;

        int mid = (l + r) >>> 1;
        Node root = new Node(a[mid]);

        root.left = makeTree(a, l, mid - 1);
        root.right = makeTree(a, mid + 1, r);

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        root.ht = Math.max(lh, rh) + 1;

        int bf = rh - lh;

        if (bf == -1)
            neg++;
        else if (bf == 0)
            zero++;
        else
            pos++;

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println("Array: " + Arrays.toString(a));

        makeTree(a, 0, n - 1);

        System.out.println("Nodes with balance factor -1: " + neg);
        System.out.println("Nodes with balance factor 0: " + zero);
        System.out.println("Nodes with balance factor +1: " + pos);
        System.out.println("Output: " + neg + " " + zero + " " + pos);

        sc.close();
    }
}