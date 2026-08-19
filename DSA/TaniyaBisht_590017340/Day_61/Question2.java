
import java.util.*;
class WA{
    static int dfs(int person, ArrayList<Integer>[] graph) {
        int maxDepth = 0;
        for (int child : graph[person]) {
            maxDepth = Math.max(maxDepth, dfs(child, graph));
        }
        return maxDepth + 1;
    }
    public static void main(String[] args) {
        int n = 5;
        int[] mentor = {-1, 1, 2, 1, -1};
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            if (mentor[i - 1] != -1) {
                graph[mentor[i - 1]].add(i);
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (mentor[i - 1] == -1) {
                answer = Math.max(answer, dfs(i, graph));
            }
        }
        System.out.println("Minimum Groups:" + answer);
    }
}