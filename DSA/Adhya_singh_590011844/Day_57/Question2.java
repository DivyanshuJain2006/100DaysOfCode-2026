import java.io.*;
import java.util.*;

public class Main {

    static boolean isMirror(
            long[] a, int i,
            long[] b, int j) {

        if (isMissing(a, i) && isMissing(b, j)) {
            return true;
        }

        if (isMissing(a, i) || isMissing(b, j)) {
            return false;
        }

        if (a[i] != b[j]) {
            return false;
        }

        return isMirror(a, 2 * i + 1, b, 2 * j + 2)
            && isMirror(a, 2 * i + 2, b, 2 * j + 1);
    }

    static boolean isMissing(long[] tree, int index) {
        return index >= tree.length || tree[index] == -1;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            long[] tree1 = new long[n1];

            for (int i = 0; i < n1; i++) {
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                tree1[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());

            int n2 = Integer.parseInt(st.nextToken());
            long[] tree2 = new long[n2];

            for (int i = 0; i < n2; i++) {
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                tree2[i] = Long.parseLong(st.nextToken());
            }

            if (isMirror(tree1, 0, tree2, 0)) {
                output.append("YES\n");
            } else {
                output.append("NO\n");
            }
        }

        System.out.print(output);
    }
}