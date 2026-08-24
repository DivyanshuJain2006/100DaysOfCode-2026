import java.util.*;

public class Question2 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node[] split(Node root, int k) {

        if (root == null)
            return new Node[]{null, null};

        if (root.val < k) {

            Node[] result = split(root.right, k);

            root.right = result[0];

            return new Node[]{root, result[1]};

        } else {

            Node[] result = split(root.left, k);

            root.left = result[1];

            return new Node[]{result[0], root};
        }
    }

    static Node buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1)
            return null;

        Node root = new Node(arr[0]);

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (i < arr.length) {

            Node current = q.poll();

            if (arr[i] != -1) {
                current.left = new Node(arr[i]);
                q.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                q.add(current.right);
            }
            i++;
        }

        return root;
    }

    static void preorder(Node root, StringBuilder result) {

        if (root == null)
            return;

        result.append(root.val).append(" ");

        preorder(root.left, result);
        preorder(root.right, result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();

        Node root = buildTree(arr);

        Node[] trees = split(root, k);

        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();

        preorder(trees[0], first);
        preorder(trees[1], second);

        if (first.length() == 0)
            System.out.println("EMPTY");
        else
            System.out.println(first.toString().trim());

        if (second.length() == 0)
            System.out.println("EMPTY");
        else
            System.out.println(second.toString().trim());
    }
}
