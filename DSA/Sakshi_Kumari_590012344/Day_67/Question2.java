class Solution {
    int minusOne = 0;
    int zero = 0;
    int plusOne = 0;

    public int[] balanceSpectrum(int[] nums) {
        build(nums, 0, nums.length - 1);

        return new int[]{minusOne, zero, plusOne};
    }

    private int build(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }

        int mid = (left + right) / 2;

        int leftHeight = build(nums, left, mid - 1);
        int rightHeight = build(nums, mid + 1, right);

        int balance = leftHeight - rightHeight;

        if (balance == -1) {
            minusOne++;
        } else if (balance == 0) {
            zero++;
        } else {
            plusOne++;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
