import java.util.*;

public class Main {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node curr = q.poll();

            if (i < arr.length && arr[i] != -1) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }

        return root;
    }

    static Node[] splitBST(Node root, int k) {
        if (root == null) {
            return new Node[]{null, null};
        }

        if (root.val < k) {
            Node[] splitRight = splitBST(root.right, k);
            root.right = splitRight[0];
            return new Node[]{root, splitRight[1]};
        } else {
            Node[] splitLeft = splitBST(root.left, k);
            root.left = splitLeft[1];
            return new Node[]{splitLeft[0], root};
        }
    }

    static void preorder(Node root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    static void printTree(Node root) {
        if (root == null) {
            System.out.println("EMPTY");
            return;
        }

        List<Integer> result = new ArrayList<>();
        preorder(root, result);

        for (int i = 0; i < result.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] tree = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Node root = buildTree(tree);
        Node[] result = splitBST(root, k);

        printTree(result[0]);
        printTree(result[1]);
    }
}