class Solution {
    public int countPalindromePaths(int[] tree) {
        if (tree == null || tree.length == 0 || tree[0] == -1) return 0;
        return dfs(tree, 0, 0);
    }
    
    private int dfs(int[] tree, int i, int mask) {
        if (i >= tree.length || tree[i] == -1) return 0;
        
        int digit = tree[i];
        mask ^= (1 << digit);   // flip parity bit for this digit
        
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        boolean isLeaf = (left >= tree.length || tree[left] == -1) &&
                          (right >= tree.length || tree[right] == -1);
        
        if (isLeaf) {
            return (Integer.bitCount(mask) <= 1) ? 1 : 0;
        }
        
        int count = 0;
        count += dfs(tree, left, mask);
        count += dfs(tree, right, mask);
        return count;
    }
}
