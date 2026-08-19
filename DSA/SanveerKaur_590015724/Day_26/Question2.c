#include <stdbool.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

bool tripletSumCheck(int* arr, int arrSize) {
    qsort(arr, arrSize, sizeof(int), compare);

    for (int k = arrSize - 1; k >= 2; k--) {
        int left = 0;
        int right = k - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == arr[k]) {
                return true;
            }
            else if (sum < arr[k]) {
                left++;
            }
            else {
                right--;
            }
        }
    }

    return false;
}