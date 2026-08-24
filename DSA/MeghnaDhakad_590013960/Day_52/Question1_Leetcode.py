class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        from collections import Counter
        
        # Count frequencies of each character
        freq_map = Counter(s)
        
        # Get the unique frequency values
        unique_frequencies = set(freq_map.values())
        
        # If there is only one unique frequency, return True
        return len(unique_frequencies) == 1