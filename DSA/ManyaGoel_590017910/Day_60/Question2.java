import java.util.Scanner;

public class Question2 {
    static int countSafeCampsites(int[] tree, int n, int index, int pathMax) {
        if (index >= n || tree[index] == -1) {
            return 0;
        }
        int value = tree[index];
        int safeHere = value >= pathMax ? 1 : 0;
        int newMax = Math.max(pathMax, value);
        return safeHere + countSafeCampsites(tree, n, 2 * index + 1, newMax) + countSafeCampsites(tree, n, 2 * index + 2, newMax);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            System.out.println("\nTest case " + tc);

            System.out.print("Enter number of elements (n): ");
            int n = sc.nextInt();

            int[] tree = new int[n];

            System.out.print("Enter " + n + " elements of the level-order tree (-1 for null): ");
            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }
            System.out.println("Tree : " + java.util.Arrays.toString(tree));
            int answer = (n == 0 || tree[0] == -1)? 0 : countSafeCampsites(tree, n, 0, Integer.MIN_VALUE);
            System.out.println("Safe campsites: " + answer);
        }

        sc.close();
    }
}