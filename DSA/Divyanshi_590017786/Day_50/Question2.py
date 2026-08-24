import heapq

def quarry_smasher(rocks):
    # Convert to max heap using negative values
    rocks = [-rock for rock in rocks]
    heapq.heapify(rocks)

    while len(rocks) > 1:
        first = -heapq.heappop(rocks)
        second = -heapq.heappop(rocks)

        if first != second:
            heapq.heappush(rocks, -(first - second))

    if rocks:
        return -rocks[0]
    return 0


# Input
rocks = list(map(int, input("Enter rock weights: ").split()))

# Output
print("Remaining Rock Weight:", quarry_smasher(rocks))