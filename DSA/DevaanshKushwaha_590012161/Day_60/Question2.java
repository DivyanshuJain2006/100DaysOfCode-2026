class Solution {
    public int countSafeCampsites(int[] tree) {
        if (tree == null || tree.length == 0 || tree[0] == -1) return 0;
        return dfs(tree, 0, Integer.MIN_VALUE);
    }
    
    private int dfs(int[] tree, int i, int maxSoFar) {
        if (i >= tree.length || tree[i] == -1) return 0;
        
        int val = tree[i];
        int count = (val >= maxSoFar) ? 1 : 0;
        
        int newMax = Math.max(maxSoFar, val);
        
        count += dfs(tree, 2 * i + 1, newMax); // left child
        count += dfs(tree, 2 * i + 2, newMax); // right child
        
        return count;
    }
}
