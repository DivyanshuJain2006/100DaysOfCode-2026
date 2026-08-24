n = int(input())
mentor = list(map(int, input().split()))

children = [[] for _ in range(n + 1)]

for i in range(n):
    if mentor[i] != -1:
        children[mentor[i]].append(i + 1)

def height(node):
    if not children[node]:
        return 1

    return 1 + max(height(child) for child in children[node])

answer = 0

for i in range(1, n + 1):
    if mentor[i - 1] == -1:
        answer = max(answer, height(i))

print(answer)