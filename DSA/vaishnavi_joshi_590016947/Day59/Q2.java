import java.io.*;
import java.util.*;

public class Main {

    static class State {
        int index;
        int mask;

        State(int index, int mask) {
            this.index = index;
            this.mask = mask;
        }
    }

    static long countValidPaths(int[] tree) {
        int n = tree.length;

        if (n == 0 || tree[0] == -1) {
            return 0;
        }

        long answer = 0;

        // Iterative DFS to avoid StackOverflowError for n = 100000
        Deque<State> stack = new ArrayDeque<>();

        // Root's digit
        int rootMask = 1 << tree[0];
        stack.push(new State(0, rootMask));

        while (!stack.isEmpty()) {
            State current = stack.pop();

            int index = current.index;
            int mask = current.mask;

            // Heap-array children
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            boolean hasChild = false;

            // Left child
            if (left < n && tree[left] != -1) {
                hasChild = true;

                int newMask = mask ^ (1 << tree[left]);
                stack.push(new State(left, newMask));
            }

            // Right child
            if (right < n && tree[right] != -1) {
                hasChild = true;

                int newMask = mask ^ (1 << tree[right]);
                stack.push(new State(right, newMask));
            }

            // Current node is a leaf
            if (!hasChild) {
                if (Integer.bitCount(mask) <= 1) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            int[] tree = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
            }

            output.append(countValidPaths(tree)).append('\n');
        }

        System.out.print(output);
    }
}