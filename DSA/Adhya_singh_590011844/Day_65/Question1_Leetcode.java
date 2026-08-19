import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int currentCount;
    static int maxCount;
    static Integer previous;
    static List<Integer> modes;

    static int[] findMode(TreeNode root) {

        currentCount = 0;
        maxCount = 0;
        previous = null;
        modes = new ArrayList<>();

        inorder(root);

        int[] result = new int[modes.size()];

        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (previous != null && previous == root.val) {
            currentCount++;
        } else {
            currentCount = 1;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;

            modes.clear();
            modes.add(root.val);
        }

        else if (currentCount == maxCount) {
            modes.add(root.val);
        }

        previous = root.val;

        inorder(root.right);
    }

    static TreeNode buildTree(int[] values) {

        if (values.length == 0 || values[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {

            TreeNode current = queue.poll();

            if (i < values.length && values[i] != -1) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }

            i++;

            if (i < values.length && values[i] != -1) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String[] args) {

        int[] values = {
            1, -1, 2, 2
        };

        TreeNode root = buildTree(values);

        int[] result = findMode(root);

        System.out.println(Arrays.toString(result));
    }
}