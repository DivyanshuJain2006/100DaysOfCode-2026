import java.util.*;

public class Question2 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1)
            return null;

        Node root = new Node(arr[0]);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            Node current = queue.poll();

            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    static int findLCA(Node root, int a, int b) {

        while (root != null) {

            if (a < root.data && b < root.data) {
                root = root.left;
            }
            else if (a > root.data && b > root.data) {
                root = root.right;
            }
            else {
                return root.data;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        Node root = buildTree(arr);

        System.out.println(findLCA(root, a, b));

        sc.close();
    }
}