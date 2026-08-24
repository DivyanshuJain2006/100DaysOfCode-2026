import java.util.*;

public class SecretCode {

    static int countValidPaths(int[] tree) {
        int[] count = new int[10];

        return dfs(tree, 0, count);
    }

    static int dfs(int[] tree, int index, int[] count) {

        // If index is outside the array or node is missing
        if (index >= tree.length || tree[index] == -1) {
            return 0;
        }

        // Add current digit
        int digit = tree[index];
        count[digit]++;

        // Check if current node is a leaf
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if ((left >= tree.length || tree[left] == -1) &&
            (right >= tree.length || tree[right] == -1)) {

            int oddCount = 0;

            for (int i = 0; i < 10; i++) {
                if (count[i] % 2 == 1) {
                    oddCount++;
                }
            }

            // Backtrack before returning
            count[digit]--;

            return oddCount <= 1 ? 1 : 0;
        }

        // Explore left and right
        int answer = 0;

        answer += dfs(tree, left, count);
        answer += dfs(tree, right, count);

        // Backtrack
        count[digit]--;

        return answer;
    }

    public static void main(String[] args) {

        int[] tree = {2, 3, 1, 3, 1, -1, 1};

        System.out.println(countValidPaths(tree));
    }
}