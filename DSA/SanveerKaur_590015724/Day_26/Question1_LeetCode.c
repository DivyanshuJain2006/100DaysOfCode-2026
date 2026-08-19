void sortColors(int* nums, int numsSize) {
    int low = 0;
    int mid = 0;
    int high = numsSize - 1;

    while (mid <= high) {

        if (nums[mid] == 0) {
            // Swap low and mid
            int temp = nums[low];
            nums[low] = nums[mid];
            nums[mid] = temp;

            low++;
            mid++;
        }

        else if (nums[mid] == 1) {
            // 1 is already in the correct middle section
            mid++;
        }

        else {
            // Swap mid and high
            int temp = nums[mid];
            nums[mid] = nums[high];
            nums[high] = temp;

            high--;
        }
    }
}