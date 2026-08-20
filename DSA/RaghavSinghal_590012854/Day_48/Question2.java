import java.util.*;

public class Main {

    static long[] reconstruct(int n, long[] b) {
        Arrays.sort(b);

        long[] a = new long[n];

        int idx = 0;

        for (int i = 0; i < n - 1; i++) {
            a[i] = b[idx];
            idx += n - 1 - i;
        }

        a[n - 1] = b[b.length - 1] + 1;

        return a;
    }

    public static void main(String[] args) {
        int n = 3;
        long[] b = {4, 2, 2};

        long[] a = reconstruct(n, b);

        System.out.println(Arrays.toString(a));
    }
}