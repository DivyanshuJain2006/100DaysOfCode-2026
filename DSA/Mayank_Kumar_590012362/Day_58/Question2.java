class Solution {
    public int lowestCommonAncestor(int[] t, int a, int b) {
        if (t == null || t.length == 0 || t[0] == -1) return -1;
        int ia = -1, ib = -1;
        for (int i = 0; i < t.length; i++) {
            if (t[i] == a) ia = i;
            if (t[i] == b) ib = i;
        }
        if (ia == -1 || ib == -1) return -1;
        while (ia != ib) {
            if (ia > ib) ia = (ia - 1) / 2;
            else ib = (ib - 1) / 2;
        }
        return t[ia];
    }
}