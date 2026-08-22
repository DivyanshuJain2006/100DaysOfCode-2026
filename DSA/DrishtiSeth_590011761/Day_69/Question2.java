import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Main {

    // Split BST into two BSTs
    // result[0] -> values < K
    // result[1] -> values >= K
    static TreeNode[] splitBST(TreeNode root, int K) {

        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val < K) {

            // Current node belongs to Branch A
            TreeNode[] result = splitBST(root.right, K);

            root.right = result[0];

            return new TreeNode[]{
                root,
                result[1]
            };

        } else {

            // Current node belongs to Branch B
            TreeNode[] result = splitBST(root.left, K);

            root.left = result[1];

            return new TreeNode[]{
                result[0],
                root
            };
        }
    }

    // Preorder traversal
    static void preorder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        result.add(root.val);

        preorder(root.left, result);
        preorder(root.right, result);
    }

    static void printPreorder(TreeNode root) {

        if (root == null) {
            System.out.println("EMPTY");
            return;
        }

        List<Integer> result = new ArrayList<>();

        preorder(root, result);

        for (int i = 0; i < result.size(); i++) {

            if (i > 0) {
                System.out.print(" ");
            }

            System.out.print(result.get(i));
        }

        System.out.println();
    }

    // Build tree from level-order array
    static TreeNode buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[arr.length];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != -1) {
                nodes[i] = new TreeNode(arr[i]);
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

    public static void main(String[] args) {

        int[] tree = {10, 5, 15, 2, 7, 12, 20};
        int K = 10;

        TreeNode root = buildTree(tree);

        TreeNode[] result = splitBST(root, K);

        // Branch A
        printPreorder(result[0]);

        // Branch B
        printPreorder(result[1]);
    }
}
