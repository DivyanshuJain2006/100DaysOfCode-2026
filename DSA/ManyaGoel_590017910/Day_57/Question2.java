import java.util.*;

public class Question2 {
    public static boolean isMirror(int[] a, int[] b, int i, int j) {

        // First node is missing
        if (i >= a.length || a[i] == -1) {
            return j >= b.length || b[j] == -1;
        }
        // First node exists but second node is missing
        if (j >= b.length || b[j] == -1) {
            return false;
        }
        // Values must match
        if (a[i] != b[j]) {
            return false;
        }
        // Mirror comparison
        return isMirror(a, b, 2 * i + 1, 2 * j + 2) && isMirror(a, b, 2 * i + 2, 2 * j + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {

            System.out.print("Enter number of elements in Warehouse 1: ");
            int n1 = sc.nextInt();
            int[] warehouse1 = new int[n1];
            System.out.println("Enter elements of Warehouse 1:");
            for (int i = 0; i < n1; i++) {
                warehouse1[i] = sc.nextInt();
            }
            System.out.print("Enter number of elements in Warehouse 2: ");
            int n2 = sc.nextInt();
            int[] warehouse2 = new int[n2];
            System.out.println("Enter elements of Warehouse 2:");
            for (int i = 0; i < n2; i++) {
                warehouse2[i] = sc.nextInt();
            }
            System.out.println("Warehouse 1: " + Arrays.toString(warehouse1));
            System.out.println("Warehouse 2: " + Arrays.toString(warehouse2));
            boolean result = isMirror(warehouse1, warehouse2, 0, 0);
            System.out.println("Result: " + (result ? "YES" : "NO"));
        }
        sc.close();
    }
}