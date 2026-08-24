public class Question2 {

    static boolean isMirror(long[] a, long[] b, int i, int j) {

        boolean aMissing = i >= a.length || a[i] == -1;

        boolean bMissing = j >= b.length || b[j] == -1;

        if (aMissing && bMissing) {
            return true;
        }

        if (aMissing || bMissing) {
            return false;
        }

        if (a[i] != b[j]) {
            return false;
        }

        return isMirror(a, b, 2 * i + 1, 2 * j + 2)
            && isMirror(a, b, 2 * i + 2, 2 * j + 1);
    }

    public static void main(String[] args) {

        long[] a = {1, 2, 3};
        long[] b = {1, 3, 2};

        System.out.println(isMirror(a, b, 0, 0) ? "YES" : "NO");

    }
}