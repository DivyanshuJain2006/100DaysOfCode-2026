import java.util.*;

public class Question2 {

    static boolean isMirror(int[] a, int[] b, int i, int j) {
        if (i >= a.length || a[i] == -1) {
            return j >= b.length || b[j] == -1;
        }

        if (j >= b.length || b[j] == -1) {
            return false;
        }

        if (a[i] != b[j]) {
            return false;
        }

        return isMirror(a, b, 2 * i + 1, 2 * j + 2)
                && isMirror(a, b, 2 * i + 2, 2 * j + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n1 = sc.nextInt();
            int[] warehouse1 = new int[n1];

            for (int i = 0; i < n1; i++) {
                warehouse1[i] = sc.nextInt();
            }

            int n2 = sc.nextInt();
            int[] warehouse2 = new int[n2];

            for (int i = 0; i < n2; i++) {
                warehouse2[i] = sc.nextInt();
            }

            System.out.println(
                isMirror(warehouse1, warehouse2, 0, 0) ? "YES" : "NO"
            );
        }

        sc.close();
    }
}