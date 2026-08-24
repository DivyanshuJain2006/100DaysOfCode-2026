import java.util.*;

public class Question2 {

    static boolean isMirror(int[] a, int[] b, int i, int j) {

        if (i >= a.length && j >= b.length)
            return true;

        if (i >= a.length || j >= b.length)
            return false;
        if (a[i] == -1 && b[j] == -1)
            return true;
        if (a[i] == -1 || b[j] == -1)
            return false;

        if (a[i] != b[j])
            return false;
        boolean left = isMirror(a, b, 2 * i + 1, 2 * j + 2);
        boolean right = isMirror(a, b, 2 * i + 2, 2 * j + 1);

        return left && right;
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

            if (isMirror(warehouse1, warehouse2, 0, 0))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        sc.close();
    }
}