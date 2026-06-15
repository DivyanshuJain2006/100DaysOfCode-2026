#include <stdio.h>

int main() {
  int arrsize;
  printf("Enter Array size: ");
  if (scanf("%d", &arrsize) != 1) {
    return 1;
  }

  int arr[arrsize];
  for (int i = 0; i < arrsize; i++) {
    scanf("%d", &arr[i]);
  }

  int sum = 0;
  for (int i = 0; i < arrsize; i++) {
    sum = sum + arr[i];
  }
  printf("%d\n", sum);
  return 0;
}
