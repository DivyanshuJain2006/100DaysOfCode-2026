import java.util.*;
class Question2 {
    int count = 0;
    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, 0);
        return count;
    }

    void dfs(TreeNode root, int mask) {

        if (root == null) return;
        mask ^= (1 << root.val);
        if (root.left == null && root.right == null) {
            if ((mask & (mask - 1)) == 0) {
                count++;
            }

            return;
        }

        dfs(root.left, mask);
        dfs(root.right, mask);
    }
}