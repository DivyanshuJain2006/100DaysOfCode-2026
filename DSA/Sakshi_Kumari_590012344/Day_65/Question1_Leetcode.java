class Solution {
    List<Integer> result = new ArrayList<>();

    Integer prev = null;
    int count = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

      
        inorder(node.left);

     
        if (prev != null && node.val == prev) {
            count++;
        } else {
            count = 1;
        }

        if (count > maxCount) {
            result.clear();
            result.add(node.val);
            maxCount = count;
        } else if (count == maxCount) {
            result.add(node.val);
        }

        prev = node.val;

     
        inorder(node.right);
    }
}
