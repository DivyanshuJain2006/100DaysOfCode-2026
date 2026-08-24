from itertools import combinations

def maximum_playlist_pleasure(length, beauty, k):
    n = len(length)
    max_pleasure = 0

    for size in range(1, k + 1):
        for songs in combinations(range(n), size):
            total_length = 0
            min_beauty = float('inf')

            for i in songs:
                total_length += length[i]
                min_beauty = min(min_beauty, beauty[i])

            pleasure = total_length * min_beauty
            max_pleasure = max(max_pleasure, pleasure)

    return max_pleasure


# Input
length = [4, 15, 3, 6]
beauty = [7, 1, 6, 8]
k = 3

print("Maximum Playlist Pleasure:", 
      maximum_playlist_pleasure(length, beauty, k))