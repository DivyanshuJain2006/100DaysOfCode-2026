class Solution {
    int[] ans = new int[3];

    public int[] balanceSpectrum(int[] arr) {
        build(arr, 0, arr.length - 1);
        return ans;
    }

    int build(int[] a, int l, int r) {
        if (l > r)
            return 0;

        int m = (l + r) / 2;

        int left = build(a, l, m - 1);
        int right = build(a, m + 1, r);

        int b = left - right;

        if (b == -1)
            ans[0]++;
        else if (b == 0)
            ans[1]++;
        else if (b == 1)
            ans[2]++;

        return Math.max(left, right) + 1;
    }
}