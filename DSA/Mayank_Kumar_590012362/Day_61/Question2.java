public class Question2 {
    public static int f(int n, int[] m) {
        int[] d = new int[n], a = {1};
        for (int i = 0; i < n; i++) {
            int x = i, c = 1;
            while (m[x] != -1) { x = m[x] - 1; c++; }
            a[0] = Math.max(a[0], c);
        } return a[0];
    }
}