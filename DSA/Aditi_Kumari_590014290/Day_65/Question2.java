package Day_65;

public class Question2 {
    public int closestValue(TreeNode root, double target) {
        int answer = root.val;

        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(answer - target) ||
                (Math.abs(root.val - target) == Math.abs(answer - target) && root.val < answer)) {
                answer = root.val;
            }

            if (root.val < target) {
                root = root.right;
            } else if (root.val > target) {
                root = root.left;
            } else {
                return root.val;
            }
        }
        return answer;
    }
}
