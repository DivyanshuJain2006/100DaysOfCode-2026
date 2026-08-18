class Solution {
    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        handleValue(node.val);
        inorder(node.right);
    }

    private void handleValue(int val) {
        // Extend streak if same as previous value, else reset streak
        if (currCount > 0 && val == currVal) {
            currCount++;
        } else {
            currCount = 1;
            currVal = val;
        }

        // Update modes list based on how this streak compares to maxCount
        if (currCount > maxCount) {
            maxCount = currCount;
            modes.clear();
            modes.add(currVal);
        } else if (currCount == maxCount) {
            modes.add(currVal);
        }
    }
}
