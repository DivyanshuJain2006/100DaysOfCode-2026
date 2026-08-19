package Day_59;

import java.util.*;

public class d59question2_technical {
    static int n;
    static int[] arr;
    static long res;

    static void dfs(int i, int mask) {
        if (i >= n || arr[i] == -1) return;

        mask ^= (1 << arr[i]); // flip bit for digit

        int l = 2 * i + 1, r = 2 * i + 2;
        boolean leaf = (l >= n || arr[l] == -1) && (r >= n || arr[r] == -1);

        if (leaf) {
            if ((mask & (mask - 1)) == 0) res++; // at most one odd freq
            return;
        }
        if (l < n && arr[l] != -1) dfs(l, mask);
        if (r < n && arr[r] != -1) dfs(r, mask);
    }

    static long solve(int[] t) {
        arr = t; n = t.length; res = 0;
        if (n > 0 && arr[0] != -1) dfs(0, 0);
        return res;}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int m = sc.nextInt();
            int[] t = new int[m];
            for (int j = 0; j < m; j++) t[j] = sc.nextInt();
            System.out.println(solve(t));
            T--; // explicit decrement
            }
        sc.close();
    }
}