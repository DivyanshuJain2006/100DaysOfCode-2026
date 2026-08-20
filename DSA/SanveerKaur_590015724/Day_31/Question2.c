#include <stdlib.h>

int* nextGreaterElement(int* arr, int arrSize, int* returnSize) {
    int* result = (int*)malloc(arrSize * sizeof(int));
    int* stack = (int*)malloc(arrSize * sizeof(int));

    int top = -1;

    *returnSize = arrSize;

    for (int i = arrSize - 1; i >= 0; i--) {

        // Remove elements that are not greater
        while (top >= 0 && stack[top] <= arr[i]) {
            top--;
        }

        // Top is the next greater element
        if (top >= 0) {
            result[i] = stack[top];
        } else {
            result[i] = -1;
        }

        // Push current element
        stack[++top] = arr[i];
    }

    free(stack);

    return result;
}