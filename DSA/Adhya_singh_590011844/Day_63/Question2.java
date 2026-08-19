import java.io.*;
import java.util.*;

public class Main {

    static int findLCA(int[] tree, int a, int b) {
        int index = 0;

        while (index < tree.length && tree[index] != -1) {

            int value = tree[index];

            if (a < value && b < value) {
                index = 2 * index + 1;
            }

            else if (a > value && b > value) {
                index = 2 * index + 2;
            }

            else {
                return value;
            }
        }

        return -1; 
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            int[] tree = new int[n];

            int count = 0;

            while (count < n) {
                StringTokenizer st =
                        new StringTokenizer(br.readLine());

                while (st.hasMoreTokens() && count < n) {
                    tree[count++] =
                            Integer.parseInt(st.nextToken());
                }
            }

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            output.append(findLCA(tree, a, b))
                   .append('\n');
        }

        System.out.print(output);
    }
}