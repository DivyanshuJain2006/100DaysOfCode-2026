class Main {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // Recursive BST insertion
    static Node insert(Node root, int value) {

        // If tree/subtree is empty
        if (root == null) {
            return new Node(value);
        }

        // Smaller values go to the left
        if (value < root.value) {
            root.left = insert(root.left, value);
        }

        // Larger values go to the right
        else if (value > root.value) {
            root.right = insert(root.right, value);
        }

        // Equal value -> do nothing (no duplicate node)

        return root;
    }

    // Recursive BST search
    static boolean search(Node root, int target) {

        // If we reach an empty subtree, value is not present
        if (root == null) {
            return false;
        }

        // Value found
        if (root.value == target) {
            return true;
        }

        // Search only the required side
        if (target < root.value) {
            return search(root.left, target);
        }

        return search(root.right, target);
    }

    public static void main(String[] args) {

        Node root = null;

        int[] gammaReadings = {50, 30, 70, 20, 40, 60, 80};

        for (int reading : gammaReadings) {
            root = insert(root, reading);
        }

        System.out.println(search(root, 60));
        System.out.println(search(root, 25));
    }
}
