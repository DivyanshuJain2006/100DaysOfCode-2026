import java.io.*;
import java.util.*;

public class Main {

    static long[] counts = new long[3];

    static int buildAndCount(int left, int right) {

        if (left > right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int leftHeight = buildAndCount(left, mid - 1);
        int rightHeight = buildAndCount(mid + 1, right);

        int balance = rightHeight - leftHeight;

        if (balance == -1) {
            counts[0]++;
        } else if (balance == 0) {
            counts[1]++;
        } else {
            counts[2]++;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        int read = 0;

        while (read < n) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            while (st.hasMoreTokens() && read < n) {
                st.nextToken();
                read++;
            }
        }

        buildAndCount(0, n - 1);

        System.out.println(
                counts[0] + " " +
                counts[1] + " " +
                counts[2]
        );
    }
}