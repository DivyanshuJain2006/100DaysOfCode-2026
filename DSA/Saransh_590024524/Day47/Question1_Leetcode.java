package DSA.Saransh_590024524.Day47;

import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;

        int[] sorted = score.clone();

        Arrays.sort(sorted);

        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            int rank = n - binarySearch(sorted, score[i]);
            if (rank == 1)
                ans[i] = "Gold Medal";
            else if (rank == 2)
                ans[i] = "Silver Medal";
            else if (rank == 3)
                ans[i] = "Bronze Medal";
            else
                ans[i] = String.valueOf(rank);
        }
        return ans;
    }
    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}