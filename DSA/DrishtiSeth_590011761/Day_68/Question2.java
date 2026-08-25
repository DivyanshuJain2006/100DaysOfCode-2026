class Solution {

    int answer = 0;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return answer;
    }

    // Returns:
    // [0] = whether subtree is BST
    // [1] = size
    // [2] = minimum value
    // [3] = maximum value
    private int[] dfs(TreeNode node) {

        if (node == null) {
            return new int[]{
                1,                  // is BST
                0,                  // size
                Integer.MAX_VALUE,  // min
                Integer.MIN_VALUE   // max
            };
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // Check if current subtree is BST
        if (left[0] == 1 &&
            right[0] == 1 &&
            left[3] < node.val &&
            node.val < right[2]) {

            int size = left[1] + right[1] + 1;

            answer = Math.max(answer, size);

            int min = Math.min(node.val, left[2]);
            int max = Math.max(node.val, right[3]);

            return new int[]{
                1,
                size,
                min,
                max
            };
        }

        // Not a BST
        return new int[]{
            0,
            0,
            Integer.MIN_VALUE,
            Integer.MAX_VALUE
        };
    }
}
