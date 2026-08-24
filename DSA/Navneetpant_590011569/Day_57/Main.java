import java.util.*;

public class Main {

    static boolean mirror(long[] a, long[] b, int i, int j) {

        if (i >= a.length || a[i] == -1) {
            return j >= b.length || b[j] == -1;
        }


        if (j >= b.length || b[j] == -1) {
            return false;
        }

        if (a[i] != b[j]) {
            return false;
        }

        
        return mirror(a, b, 2 * i + 1, 2 * j + 2)
                && mirror(a, b, 2 * i + 2, 2 * j + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n1 = sc.nextInt();
            long[] a = new long[n1];

            for (int i = 0; i < n1; i++) {
                a[i] = sc.nextLong();
            }

            int n2 = sc.nextInt();
            long[] b = new long[n2];

            for (int i = 0; i < n2; i++) {
                b[i] = sc.nextLong();
            }

            System.out.println(mirror(a, b, 0, 0) ? "YES" : "NO");
        }

        sc.close();
    }
}