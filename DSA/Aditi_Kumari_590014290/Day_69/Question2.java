public class Question2 {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node[] splitBST(Node root, int k) {
        if (root == null) {
            return new Node[]{null, null};
        }

        if (root.val < k) {
            Node[] result = splitBST(root.right, k);
            root.right = result[0];
            return new Node[]{root, result[1]};
        } else {
            Node[] result = splitBST(root.left, k);
            root.left = result[1];
            return new Node[]{result[0], root};
        }
    }

    static void preorder(Node root, StringBuilder sb) {
        if (root == null) return;

        if (sb.length() > 0) sb.append(" ");
        sb.append(root.val);

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    static String getPreorder(Node root) {
        if (root == null) return "EMPTY";

        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
}