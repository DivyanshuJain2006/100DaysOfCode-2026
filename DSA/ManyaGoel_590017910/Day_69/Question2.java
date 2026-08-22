import java.io.*;
import java.util.*;
public class Question2 {
    static int nextInt(BufferedReader br) throws IOException {
        StringBuilder s = new StringBuilder();
        int c;
        do c = br.read(); while (c <= ' ');
        while (c > ' ') {
            s.append((char) c);
            c = br.read();
        }
        return Integer.parseInt(s.toString());
    }

    static void solve(int[] tree, int k) {
        int n = tree.length, top = 0;
        int[] stack = new int[n];
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        if (tree[0] != -1) stack[top++] = 0;

        while (top > 0) {
            int i = stack[--top];
            int value = tree[i];

            if (value < k) {
                if (a.length() > 0) a.append(' ');
                a.append(value);
            } else {
                if (b.length() > 0) b.append(' ');
                b.append(value);
            }

            int left = 2 * i + 1, right = left + 1;
            if (right < n && tree[right] != -1) stack[top++] = right;
            if (left < n && tree[left] != -1) stack[top++] = left;
        }

        System.out.println(a.length() == 0 ? "EMPTY" : a);
        System.out.println(b.length() == 0 ? "EMPTY" : b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of nodes: ");
        int n = nextInt(br);

        int[] tree = new int[n];
        System.out.println("Enter the level-order tree:");
        for (int i = 0; i < n; i++) tree[i] = nextInt(br);

        System.out.print("Enter K: ");
        int k = nextInt(br);
        System.out.println("Tree: " + Arrays.toString(tree));
        System.out.println("\nOutput:");
        solve(tree, k);
    }
}