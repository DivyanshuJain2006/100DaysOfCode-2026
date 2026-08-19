from typing import List

class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        freq = {}

        for ch in s:
            freq[ch] = freq.get(ch, 0) + 1

        counts = list(freq.values())

        for count in counts:
            if count != counts[0]:
                return False

        return True