//Problem = https://leetcode.com/problems/missing-number/
//Day 1 100 DOC problem Missing Number

class Solution {

    public int missingNumber(int[] nums) {
        int arraysum = 0;
        for (int i = 0; i < nums.length; i++) {
            arraysum += nums[i];
        }
        int arraysum1 = 0;
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            arraysum1 += i;
        }
        return arraysum1 - arraysum;
    }
}
