import java.util.*;

public class Question2 {

    public static int minGroups(int n, int[] mentor) {

        int[] depth = new int[n];
        int maxDepth = 0;

        for (int i = 0; i < n; i++) {

            int current = i;
            int count = 1;

            while (mentor[current] != -1) {
                current = mentor[current] - 1;
                count++;
            }

            depth[i] = count;
            maxDepth = Math.max(maxDepth, count);
        }

        return maxDepth;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] mentor = new int[n];

        for (int i = 0; i < n; i++) {
            mentor[i] = sc.nextInt();
        }

        System.out.println(minGroups(n, mentor));

        sc.close();
    }
}