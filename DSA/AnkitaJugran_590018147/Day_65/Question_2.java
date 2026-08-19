public class ClosestValue {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int closestValue(TreeNode root, double target) {

        int closest = root.val;

        while (root != null) {

            // Exact match
            if (root.val == target) {
                return root.val;
            }

            // Current value is closer
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }

            // Tie -> choose smaller value
            else if (Math.abs(root.val - target) == Math.abs(closest - target)) {
                closest = Math.min(closest, root.val);
            }

            // Use BST property
            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
       

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        double target = 3;

        int answer = closestValue(root, target);

        System.out.println("Closest value: " + answer);
    }
}