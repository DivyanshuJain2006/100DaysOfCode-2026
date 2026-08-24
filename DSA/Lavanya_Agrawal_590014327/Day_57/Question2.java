import java.util.*;

public class Question2 {

    static boolean isMirror(int[] a, int[] b, int i, int j) {

        boolean missingA = i >= a.length || a[i] == -1;
        boolean missingB = j >= b.length || b[j] == -1;

        if (missingA && missingB) return true;
        if (missingA || missingB || a[i] != b[j]) return false;

        return isMirror(a, b, 2 * i + 1, 2 * j + 2)
            && isMirror(a, b, 2 * i + 2, 2 * j + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] a = new int[n1];

        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] b = new int[n2];

        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();

        System.out.println(isMirror(a, b, 0, 0) ? "YES" : "NO");

        sc.close();
    }
}