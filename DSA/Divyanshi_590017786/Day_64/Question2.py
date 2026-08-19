class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def lowest_common_ancestor(root, a, b):
    if root is None:
        return -1

    if a < root.value and b < root.value:
        return lowest_common_ancestor(root.left, a, b)

    if a > root.value and b > root.value:
        return lowest_common_ancestor(root.right, a, b)

    return root.value


# Build BST
root = Node(6)

root.left = Node(2)
root.right = Node(8)

root.left.left = Node(0)
root.left.right = Node(4)

root.right.left = Node(7)
root.right.right = Node(9)

# Example
a = 2
b = 8

print(lowest_common_ancestor(root, a, b))