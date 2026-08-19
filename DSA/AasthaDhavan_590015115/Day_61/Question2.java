import java.util.*;
class Question2 {
    public static int minGroups(int n, int[] mentor) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (mentor[i] != -1) {
                int parent = mentor[i] - 1; // mentor is 1-based
                graph.get(parent).add(i);
            }
        }

        int maxDepth = 0;
        for (int i = 0; i < n; i++) {
            if (mentor[i] == -1) {
                maxDepth = Math.max(maxDepth, dfs(i, graph, 1));
            }
        }
        return maxDepth;
    }

    static int dfs(int node, List<List<Integer>> graph, int depth) {
        int max = depth;
        for (int child : graph.get(node)) {
            max = Math.max(max, dfs(child, graph, depth + 1));
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] mentor = {-1, 1, 2, 1, -1};
        System.out.println(minGroups(n, mentor));
    }
}