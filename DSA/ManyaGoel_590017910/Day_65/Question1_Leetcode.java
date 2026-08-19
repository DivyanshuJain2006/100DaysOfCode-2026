public class Question1_Leetcode {
    private int count = 0;
    private int max = 0;
    private TreeNode prev = null;
    private List<Integer> modeList = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] result = new int[modeList.size()];
        for (int i = 0; i < modeList.size(); i++) {
            result[i] = modeList.get(i);
        }
        return result;
    }
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null && node.val == prev.val) count++;
        else count = 1;
        if (count > max) {
            max = count;
            modeList.clear();
            modeList.add(node.val);
        } else if (count == max) {
            modeList.add(node.val);
        }
        prev = node;
        inorder(node.right);
    }
}