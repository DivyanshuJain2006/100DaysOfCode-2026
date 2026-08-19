class Solution {
    public int minGroups(int n, int[] mentor) {
        int[] depth = new int[n + 1]; // 1-indexed; 0 = not yet computed
        int maxDepth = 0;
        
        for (int label = 1; label <= n; label++) {
            maxDepth = Math.max(maxDepth, computeDepth(label, mentor, depth));
        }
        
        return maxDepth;
    }
    
    private int computeDepth(int label, int[] mentor, int[] depth) {
        if (depth[label] != 0) return depth[label]; // memoized
        
        int mentorLabel = mentor[label - 1];
        if (mentorLabel == -1) {
            depth[label] = 1; // root, no mentor
        } else {
            depth[label] = 1 + computeDepth(mentorLabel, mentor, depth);
        }
        
        return depth[label];
    }
}
