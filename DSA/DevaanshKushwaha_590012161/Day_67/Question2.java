class Solution {
    // counts[0] -> balance factor -1
    // counts[1] -> balance factor  0
    // counts[2] -> balance factor +1
    private int[] counts = new int[3];

    public int[] balanceSpectrum(int[] arr) {
        buildAndCount(arr, 0, arr.length - 1);
        return counts;
    }

    // Builds the subtree over arr[lo..hi], returns its height (height(null) = -1)
    private int buildAndCount(int[] arr, int lo, int hi) {
        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;      // left-middle for even-length segments

        int leftHeight  = buildAndCount(arr, lo, mid - 1);
        int rightHeight = buildAndCount(arr, mid + 1, hi);

        int bf = leftHeight - rightHeight;  // guaranteed in {-1, 0, 1}
        counts[bf + 1]++;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
