import java.util.*;

public class Main {

    static boolean isMirror(long[] a, long[] b, int i, int j) {

        // Both nodes are missing
        if (i >= a.length && j >= b.length) {
            return true;
        }

        // One node is missing
        if (i >= a.length || j >= b.length) {
            return false;
        }

        // -1 means missing node
        if (a[i] == -1 && b[j] == -1) {
            return true;
        }

        if (a[i] == -1 || b[j] == -1) {
            return false;
        }

        // Values must be same
        if (a[i] != b[j]) {
            return false;
        }

        // Mirror:
        // left of A ↔ right of B
        // right of A ↔ left of B
        return isMirror(a, b, 2 * i + 1, 2 * j + 2)
            && isMirror(a, b, 2 * i + 2, 2 * j + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n1 = sc.nextInt();
            long[] warehouse1 = new long[n1];

            for (int i = 0; i < n1; i++) {
                warehouse1[i] = sc.nextLong();
            }

            int n2 = sc.nextInt();
            long[] warehouse2 = new long[n2];

            for (int i = 0; i < n2; i++) {
                warehouse2[i] = sc.nextLong();
            }

            if (isMirror(warehouse1, warehouse2, 0, 0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
