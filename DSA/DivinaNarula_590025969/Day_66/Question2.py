# The Corporate Merger

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def insert(root, val):
    if root is None:
        return TreeNode(val)

    if val < root.val:
        root.left = insert(root.left, val)
    else:
        root.right = insert(root.right, val)

    return root


def inorder(root, result):
    if root:
        inorder(root.left, result)
        result.append(root.val)
        inorder(root.right, result)


def mergeBSTs(root1, root2):
    a = []
    b = []

    inorder(root1, a)
    inorder(root2, b)

    i = j = 0
    result = []

    while i < len(a) and j < len(b):
        if a[i] < b[j]:
            value = a[i]
            i += 1
        elif a[i] > b[j]:
            value = b[j]
            j += 1
        else:
            value = a[i]
            i += 1
            j += 1

        if not result or result[-1] != value:
            result.append(value)

    while i < len(a):
        if not result or result[-1] != a[i]:
            result.append(a[i])
        i += 1

    while j < len(b):
        if not result or result[-1] != b[j]:
            result.append(b[j])
        j += 1

    return result


tree1 = list(map(int, input("Enter values for Tree 1: ").split()))
tree2 = list(map(int, input("Enter values for Tree 2: ").split()))

root1 = None
root2 = None

for value in tree1:
    if value != -1:
        root1 = insert(root1, value)

for value in tree2:
    if value != -1:
        root2 = insert(root2, value)

result = mergeBSTs(root1, root2)

print("Sorted unique employee IDs:", result)