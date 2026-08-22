import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build tree from level-order array
    static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (i < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Print preorder values satisfying the condition
    static void preorder(TreeNode root, int K, boolean lessThanK) {
        if (root == null) {
            return;
        }

        if ((lessThanK && root.val < K) ||
            (!lessThanK && root.val >= K)) {

            System.out.print(root.val + " ");
        }

        preorder(root.left, K, lessThanK);
        preorder(root.right, K, lessThanK);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] tree = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        TreeNode root = buildTree(tree);

        // Branch A: values < K
        List<Integer> branchA = new ArrayList<>();

        // Branch B: values >= K
        List<Integer> branchB = new ArrayList<>();

        collectPreorder(root, K, branchA, branchB);

        // Print Branch A
        if (branchA.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (int x : branchA) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        // Print Branch B
        if (branchB.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (int x : branchB) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    static void collectPreorder(TreeNode root, int K,
                                List<Integer> branchA,
                                List<Integer> branchB) {

        if (root == null) {
            return;
        }

        // Put node into correct branch
        if (root.val < K) {
            branchA.add(root.val);
        } else {
            branchB.add(root.val);
        }

        collectPreorder(root.left, K, branchA, branchB);
        collectPreorder(root.right, K, branchA, branchB);
    }
}