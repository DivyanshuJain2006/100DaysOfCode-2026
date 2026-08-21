arr = []
stack = []
curr = root

while curr or stack:
    while curr:
        stack.append(curr)
        curr = curr.left

    curr = stack.pop()
    arr.append(curr.val)
    curr = curr.right

max_size = 0

def isBST(values):
    for i in range(1, len(values)):
        if values[i] <= values[i - 1]:
            return False
    return True