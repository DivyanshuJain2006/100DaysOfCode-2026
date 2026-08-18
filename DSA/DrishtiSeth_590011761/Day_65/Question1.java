class Solution {

    ArrayList<Integer> result = new ArrayList<>();

    int currentCount = 0;
    int maxCount = 0;

    Integer previous = null;

    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        // Left subtree
        inorder(root.left);

        // Count current value
        if (previous == null || root.val != previous) {
            currentCount = 1;
        } else {
            currentCount++;
        }

        previous = root.val;

        // Update result
        if (currentCount > maxCount) {

            maxCount = currentCount;

            result.clear();
            result.add(root.val);

        } else if (currentCount == maxCount) {

            result.add(root.val);
        }

        // Right subtree
        inorder(root.right);
    }

    public int[] findMode(TreeNode root) {

        inorder(root);

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
