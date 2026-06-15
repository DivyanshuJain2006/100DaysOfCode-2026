int missingNumber(int *nums, int numsSize) {

  int arrsum = 0;
  int n = numsSize;
  int totalsum = (n * (n + 1)) / 2;
  ;
  for (int i = 0; i < numsSize; i++) {
    arrsum = arrsum + nums[i];
  }
  int missingno = totalsum - arrsum;
  return missingno;
}