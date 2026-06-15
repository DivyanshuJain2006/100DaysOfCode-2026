#leetcode question 268

def missingNumber(nums):
    n = len(nums)

    expected_sum = n * (n + 1) // 2
    actual_sum = 0

    for i in range(n):
        actual_sum += nums[i]

    return expected_sum - actual_sum