n = int(input())
tree = list(map(int, input().split()))
a, b = map(int, input().split())


x = tree.index(a)
y = tree.index(b)


while x != y:
    if x > y:
        x = (x - 1) // 2
    else:
        y = (y - 1) // 2

print(tree[x])