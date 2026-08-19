a = []
stack = []
cur = root1

while cur or stack:
    while cur:
        stack.append(cur)
        cur = cur.left
    cur = stack.pop()
    a.append(cur.val)
    cur = cur.right

b = []
stack = []
cur = root2

while cur or stack:
    while cur:
        stack.append(cur)
        cur = cur.left
    cur = stack.pop()
    b.append(cur.val)
    cur = cur.right

print(sorted(set(a + b)))