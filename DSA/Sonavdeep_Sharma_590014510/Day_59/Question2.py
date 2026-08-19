tree = list(map(int, input().split()))

n = len(tree)
stack = [(0, [0] * 10)]
ans = 0

while stack:
    i, freq = stack.pop()

    if i >= n or tree[i] == -1:
        continue

    freq[tree[i]] += 1

    left = 2 * i + 1
    right = 2 * i + 2

    
    if (left >= n or tree[left] == -1) and (right >= n or tree[right] == -1):
        odd = 0

        for x in freq:
            if x % 2 == 1:
                odd += 1

        if odd <= 1:
            ans += 1

    else:
        if right < n and tree[right] != -1:
            stack.append((right, freq.copy()))

        if left < n and tree[left] != -1:
            stack.append((left, freq.copy()))

print(ans)