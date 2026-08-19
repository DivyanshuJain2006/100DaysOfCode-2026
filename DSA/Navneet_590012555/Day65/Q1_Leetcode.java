class Solution {
    int prev = 0;
    int count = 0;
    int max = 0;

    public int[] findMode(TreeNode root) {
        ArrayList<Integer> a = new ArrayList<>();
        dfs(root, a);

        int[] ans = new int[a.size()];

        for (int i = 0; i < a.size(); i++)
            ans[i] = a.get(i);

        return ans;
    }

    void dfs(TreeNode root, ArrayList<Integer> a) {
        if (root == null)
            return;

        dfs(root.left, a);

        if (root.val == prev)
            count++;
        else
            count = 1;

        if (count > max) {
            a.clear();
            a.add(root.val);
            max = count;
        } 
        else if (count == max) {
            a.add(root.val);
        }

        prev = root.val;

        dfs(root.right, a);
    }
}
