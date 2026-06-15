#include <stdio.h>
int missingNumber(int* nums, int numsSize) {
    int total = numsSize * (numsSize + 1) / 2;
    int sum = 0;

    for (int i = 0; i < numsSize; i++) {
        sum += nums[i];
    }

    return total - sum;
}
int main() {
    int n;

    printf("Enter n: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter %d numbers (from 0 to %d with one missing):\n", n, n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    int result = missingNumber(arr, n);

    printf("Missing number is: %d\n", result);

    return 0;
}