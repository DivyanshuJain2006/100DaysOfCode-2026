#include <stdio.h>
int arraySum(int* nums, int numsSize) {
int sum = 0;

for(int i = 0; i < numsSize; i++) {
    sum += nums[i];
}

return sum;
}


int main() {
int n;

printf("Enter size of array: ");
scanf("%d", &n);

int arr[n];

printf("Enter %d elements:\n", n);
for(int i = 0; i < n; i++) {
    scanf("%d", &arr[i]);
}

int result = arraySum(arr, n);

printf("Sum of array = %d\n", result);

return 0;

}
