int missingNumber(int* nums, int numsSize) {
    int i, sum1=0, sum2=0;

   for(i=0;i<numsSize;i++) {
    sum1=sum1+nums[i];
   }
   for(i=0;i<=numsSize;i++) {
    sum2=sum2+i;
   }

   return sum2-sum1;

}
