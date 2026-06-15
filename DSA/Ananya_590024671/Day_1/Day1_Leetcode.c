int missingNumber(int* nums, int numsSize) {
    int actualsum=0;
    int expectedsum=0;
    for (int i=0; i<numsSize; i++){
            actualsum=actualsum+nums[i];
    }
    for(int i=0; i<=numsSize; i++){
        expectedsum=expectedsum+i;
    }
    return expectedsum-actualsum;
}
