arr = [1, 2, 3, 4, 5, 6, 7]

count = [0, 0, 0]
stack = [(0, len(arr) - 1)]

while stack:
    l, r = stack.pop()

    if l > r:
        continue

    mid = (l + r) // 2

    left = mid - l
    right = r - mid
    
    if left == right:
        count[1] += 1
    elif left > right:
        count[0] += 1
    else:
        count[2] += 1

    stack.append((l, mid - 1))
    stack.append((mid + 1, r))

print(count)