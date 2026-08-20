import java.io.*;
import java.util.*;

public class Main {

    // counts[0] = balance factor -1
    // counts[1] = balance factor  0
    // counts[2] = balance factor +1
    static int[] counts = new int[3];

    // Returns height of the subtree
    static int build(int left, int right) {

        // Empty subtree
        if (left > right) {
            return 0;
        }

        // Left-middle element for even length
        int mid = left + (right - left) / 2;

        // Build left and right subtrees
        int leftHeight = build(left, mid - 1);
        int rightHeight = build(mid + 1, right);

        // Balance factor = right height - left height
        int balance = rightHeight - leftHeight;

        if (balance == -1) {
            counts[0]++;
        } else if (balance == 0) {
            counts[1]++;
        } else {
            counts[2]++;
        }

        // Height of current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // We don't actually need the array values.
        // Only n determines the structure of this BST.
        for (int i = 0; i < n; i++) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            st.nextToken();
        }

        build(0, n - 1);

        System.out.println(counts[0] + " " + counts[1] + " " + counts[2]);
    }
}