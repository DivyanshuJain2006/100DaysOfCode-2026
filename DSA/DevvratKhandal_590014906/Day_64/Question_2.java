import java.util.*;

class Question_2 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Build BST from level-order array
    static Node buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1)
            return null;

        Node root = new Node(arr[0]);

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {

            Node current = q.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                q.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Find Lowest Common Ancestor
    static Node findLCA(Node root, int a, int b) {

        while (root != null) {

            // Both values are smaller
            if (a < root.data && b < root.data) {
                root = root.left;
            }

            // Both values are larger
            else if (a > root.data && b > root.data) {
                root = root.right;
            }

            // They are on different sides
            // or one of them is the root
            else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        for (int test = 1; test <= t; test++) {

            System.out.println("\nTest Case " + test);

            System.out.print("Enter number of nodes: ");
            int n = sc.nextInt();

            int[] arr = new int[n];

            System.out.println("Enter tree elements in level-order (-1 for NULL):");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.print("Enter first room number (a): ");
            int a = sc.nextInt();

            System.out.print("Enter second room number (b): ");
            int b = sc.nextInt();

            Node root = buildTree(arr);

            Node lca = findLCA(root, a, b);

            if (lca != null) {
                System.out.println("Lowest Common Ancestor = " + lca.data);
            } else {
                System.out.println("Lowest Common Ancestor not found");
            }
        }

        sc.close();
    }
}