import java.util.*;

class MirrorImage {

    static boolean isMirror(long[] a, int i, long[] b, int j) {

        // Both positions are missing
        if (!exists(a, i) && !exists(b, j)) {
            return true;
        }

        // Only one position is missing
        if (!exists(a, i) || !exists(b, j)) {
            return false;
        }

        // One of the nodes is explicitly -1
        if (a[i] == -1 && b[j] == -1) {
            return true;
        }

        if (a[i] == -1 || b[j] == -1) {
            return false;
        }

        // Values must be equal
        if (a[i] != b[j]) {
            return false;
        }

        // A's left  <-> B's right
        // A's right <-> B's left
        return isMirror(a, 2 * i + 1, b, 2 * j + 2)
            && isMirror(a, 2 * i + 2, b, 2 * j + 1);
    }

    static boolean exists(long[] arr, int index) {
        return index < arr.length;
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

            if (isMirror(warehouse1, 0, warehouse2, 0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}