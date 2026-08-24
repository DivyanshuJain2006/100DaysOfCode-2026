n = int(input())
tree = list(map(int, input().split()))

safe = 0

for i in range(n):
    if tree[i] == -1:
        continue

    j = i
    maximum = tree[i]

    while j > 0:
        parent = (j - 1) // 2

        if tree[parent] == -1:
            break

        maximum = max(maximum, tree[parent])
        j = parent

    if tree[i] >= maximum:
        safe += 1

print(safe)