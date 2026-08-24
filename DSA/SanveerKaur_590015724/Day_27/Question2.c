#include <stdio.h>

long long countAtMost(int* arr, int arrSize, int limit) {
    long long len = 0;
    long long result = 0;

    for (int i = 0; i < arrSize; i++) {
        if (arr[i] <= limit) {
            len++;
            result += len;
        } else {
            len = 0;
        }
    }

    return result;
}

long long countSubarrays(int* arr, int arrSize, int l, int r) {
    return countAtMost(arr, arrSize, r)
         - countAtMost(arr, arrSize, l - 1);
}