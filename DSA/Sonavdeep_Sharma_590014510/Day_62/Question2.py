n = int(input())
tree = list(map(int, input().split()))

dp = [[0, 0] for _ in range(n)]

for i in range(n - 1, -1, -1):
    if tree[i] == -1:
        continue

    left = 2 * i + 1
    right = 2 * i + 2

    rob = tree[i]
    skip = 0

    if left < n and tree[left] != -1:
        rob += dp[left][1]
        skip += max(dp[left])

    if right < n and tree[right] != -1:
        rob += dp[right][1]
        skip += max(dp[right])

    dp[i][0] = rob
    dp[i][1] = skip

print(max(dp[0]))