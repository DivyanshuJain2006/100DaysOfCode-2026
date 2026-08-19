public class Question1_Leetcode {
    private int freq = 0;
    private int maxFreq = 0;
    private TreeNode prev = null;
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
        if (prev != null && node.val == prev.val) {
            freq++;
        } else {
            freq = 1;
        }
        if (freq > maxFreq) {
            maxFreq = freq;
            modes.clear();
            modes.add(node.val);
        } else if (freq == maxFreq) {
            modes.add(node.val);
        }
        prev = node;
        inorder(node.right);
    }
}