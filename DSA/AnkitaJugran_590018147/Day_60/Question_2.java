public class SafeCampsite {

    static int countSafeCampsites(int[] tree) {
        return dfs(tree, 0, Integer.MIN_VALUE);
    }

    static int dfs(int[] tree, int index, int maxSoFar) {

        // Missing node
        if (index >= tree.length || tree[index] == -1) {
            return 0;
        }

        int current = tree[index];

        // Check whether current node is safe
        int safe = 0;

        if (current >= maxSoFar) {
            safe = 1;
        }

        // Update maximum value seen on this path
        int newMax = Math.max(maxSoFar, current);

        // Find children
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // DFS on left and right
        safe += dfs(tree, left, newMax);
        safe += dfs(tree, right, newMax);

        return safe;
    }

    public static void main(String[] args) {

        int[] tree = {3, 1, 4, 3, -1, 1, 5};

        System.out.println(countSafeCampsites(tree));
    }
}