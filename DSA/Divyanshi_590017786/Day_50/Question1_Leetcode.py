from typing import List
import heapq

class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        heap = []

        for i, num in enumerate(nums):
            heapq.heappush(heap, (num, i))

        for _ in range(k):
            value, index = heapq.heappop(heap)
            value *= multiplier
            nums[index] = value
            heapq.heappush(heap, (value, index))

        return nums