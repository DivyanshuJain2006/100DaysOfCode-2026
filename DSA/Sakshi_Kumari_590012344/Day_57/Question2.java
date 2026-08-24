import java.util.*;

class Main {

    static boolean isMirror(int[] a, int[] b) {
        if (a.length != b.length)
            return false;

        int n = a.length;

        for (int i = 0; i < n; i++) {
            if (a[i] != b[n - 1 - i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        if (isMirror(a, b))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
