import java.util.*;

class Question_1 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Build tree from level-order input
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

    // Find sum of nodes in [low, high]
    static int rangeSum(Node root, int low, int high) {
        if (root == null)
            return 0;

        int sum = 0;

        if (root.data >= low && root.data <= high) {
            sum += root.data;
        }

        // BST property
        if (root.data > low) {
            sum += rangeSum(root.left, low, high);
        }

        if (root.data < high) {
            sum += rangeSum(root.right, low, high);
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes/elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter tree elements in level-order (-1 for NULL):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter low: ");
        int low = sc.nextInt();

        System.out.print("Enter high: ");
        int high = sc.nextInt();

        Node root = buildTree(arr);

        int result = rangeSum(root, low, high);

        System.out.println("Sum of nodes in range [" + low + ", " + high + "] = " + result);

        sc.close();
    }
}