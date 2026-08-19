from typing import List

class Solution:
    def mostFrequentEven(self, nums: List[int]) -> int:
        freq = {}

        for num in nums:
            if num % 2 == 0:
                freq[num] = freq.get(num, 0) + 1

        if not freq:
            return -1

        ans = -1
        max_freq = 0

        for num, count in freq.items():
            if count > max_freq or (count == max_freq and num < ans):
                max_freq = count
                ans = num

        return ans