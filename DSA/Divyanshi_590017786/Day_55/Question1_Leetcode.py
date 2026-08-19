from typing import List

class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        arr = []

        for i in range(len(nums)):
            arr.append((nums[i], i))

        # Sort by value in descending order
        arr.sort(reverse=True)

        # Pick the k largest elements
        selected = arr[:k]

        # Restore original order
        selected.sort(key=lambda x: x[1])

        result = []

        for value, index in selected:
            result.append(value)

        return result