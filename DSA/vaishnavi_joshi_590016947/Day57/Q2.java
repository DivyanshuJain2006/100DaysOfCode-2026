import java.io.*;
import java.util.*;

public class Main {

    // Check whether two trees are mirror images
    static boolean isMirror(int[] a, int[] b, int i, int j) {

        // If both positions are outside the array,
        // both nodes are missing
        if (i >= a.length && j >= b.length) {
            return true;
        }

        // If one node exists and the other doesn't
        if (i >= a.length || j >= b.length) {
            return false;
        }

        // If one of the nodes is missing and other exists
        if (a[i] == -1 || b[j] == -1) {
            return a[i] == -1 && b[j] == -1;
        }

        // Values must be equal
        if (a[i] != b[j]) {
            return false;
        }

        // For mirror:
        // left of first  <-> right of second
        // right of first <-> left of second

        int leftA = 2 * i + 1;
        int rightA = 2 * i + 2;

        int leftB = 2 * j + 1;
        int rightB = 2 * j + 2;

        return isMirror(a, b, leftA, rightB)
                && isMirror(a, b, rightA, leftB);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {

            // Read n1
            int n1 = Integer.parseInt(br.readLine().trim());

            // Read warehouse 1
            int[] warehouse1 = new int[n1];

            int index = 0;

            while (index < n1) {
                String line = br.readLine();

                if (line == null || line.trim().isEmpty()) {
                    continue;
                }

                StringTokenizer st = new StringTokenizer(line);

                while (st.hasMoreTokens() && index < n1) {
                    warehouse1[index++] =
                            Integer.parseInt(st.nextToken());
                }
            }

            // Read n2
            int n2 = Integer.parseInt(br.readLine().trim());

            // Read warehouse 2
            int[] warehouse2 = new int[n2];

            index = 0;

            while (index < n2) {
                String line = br.readLine();

                if (line == null || line.trim().isEmpty()) {
                    continue;
                }

                StringTokenizer st = new StringTokenizer(line);

                while (st.hasMoreTokens() && index < n2) {
                    warehouse2[index++] =
                            Integer.parseInt(st.nextToken());
                }
            }

            boolean result;

            // Different number of elements can still technically
            // represent trees with trailing missing nodes, but
            // normally the given representation includes all nodes.
            result = isMirror(warehouse1, warehouse2, 0, 0);

            if (result) {
                output.append("YES\n");
            } else {
                output.append("NO\n");
            }
        }

        System.out.print(output);
    }
}