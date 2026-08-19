# The Conference Room

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


def lowestCommonAncestor(root, a, b):
    current = root

    while current:
        if a < current.val and b < current.val:
            current = current.left
        elif a > current.val and b > current.val:
            current = current.right
        else:
            return current.val


values = list(map(int, input("Enter tree values: ").split()))
a, b = map(int, input("Enter two room numbers: ").split())

root = None

for value in values:
    root = insert(root, value)

print("Lowest Common Ancestor:", lowestCommonAncestor(root, a, b))