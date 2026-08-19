class Solution {

    public int countPalindromicPaths(int[] tree) {
        if (tree == null || tree.length == 0 || tree[0] == -1) {
            return 0;
        }

        return dfs(tree, 0, 0);
    }

    private int dfs(int[] tree, int index, int mask) {

  
        if (index >= tree.length || tree[index] == -1) {
            return 0;
        }

        mask ^= (1 << tree[index]);

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // Leaf node
        if ((left >= tree.length || tree[left] == -1) &&
            (right >= tree.length || tree[right] == -1)) {

            if (mask == 0 || (mask & (mask - 1)) == 0) {
                return 1;
            }

            return 0;
        }

        return dfs(tree, left, mask) +
               dfs(tree, right, mask);
    }
}
