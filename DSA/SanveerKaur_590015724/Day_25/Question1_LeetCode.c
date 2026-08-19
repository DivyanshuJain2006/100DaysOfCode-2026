#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int triangleNumber(int* nums, int numsSize) {
    
    qsort(nums, numsSize, sizeof(int), compare);

    int count = 0;

    // Fix the largest side
    for (int k = numsSize - 1; k >= 2; k--) {
        
        int i = 0;
        int j = k - 1;

        while (i < j) {
            
            // nums[i] + nums[j] > nums[k]
            if (nums[i] + nums[j] > nums[k]) {
                
                // Every index from i to j-1
                // can form a valid triangle with j and k
                count += j - i;
                j--;
                
            } else {
                i++;
            }
        }
    }

    return count;
}