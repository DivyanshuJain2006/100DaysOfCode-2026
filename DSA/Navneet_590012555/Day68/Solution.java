package DSA.Navneet_590012555.Day68;

public class Solution {
    int ans = 0;

    public int largestBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    int[] dfs(TreeNode root) {
        if (root == null)
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] l = dfs(root.left);
        int[] r = dfs(root.right);

        if (l[0] == 1 && r[0] == 1 &&
            l[2] < root.val && root.val < r[1]) {

            int size = l[3] + r[3] + 1;

            ans = Math.max(ans, size);

            int mn = Math.min(root.val, l[1]);
            int mx = Math.max(root.val, r[2]);

            return new int[]{1, mn, mx, size};
        }

        return new int[]{0, 0, 0, 0};
    }
}{

}
