import java.util.*;

public class Main {

    static int minimumGroups(int n, int[] mentor) {
        int[] depth = new int[n];
        int maxDepth = 0;

        for (int i = 0; i < n; i++) {
            if (mentor[i] == -1) {
                depth[i] = 0;
            } else {
                int parent = mentor[i] - 1;
                depth[i] = depth[parent] + 1;
            }

            maxDepth = Math.max(maxDepth, depth[i]);
        }

        return maxDepth + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] mentor = new int[n];

        for (int i = 0; i < n; i++) {
            mentor[i] = sc.nextInt();
        }

        System.out.println(minimumGroups(n, mentor));

        sc.close();
    }
}
