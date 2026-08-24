
import java.util.*;
class SP{
    static class Node {
        int data; Node left; Node right;
        Node(int data) {
            this.data = data;
        }
    }
    static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
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
    static Node findLCA(Node root, int a, int b) {
        if (root == null) {
            return null;
        }
        if (root.data == a || root.data == b) {
            return root;
        }
        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
    static boolean exists(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.data == value) {
            return true;
        }
        return exists(root.left, value) || exists(root.right, value);
    }
    public static void main(String[] args) {
        int[] tree = { 3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4
        };
        int a = 5;
        int b = 1;
        Node root = buildTree(tree);
        if (!exists(root, a) || !exists(root, b)) {
            System.out.println(-1);
        } 
        else {
            Node lca = findLCA(root, a, b);
            System.out.println(lca.data);
        }
    }
}