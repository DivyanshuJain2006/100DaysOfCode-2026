class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def closest_value(root, target):
    if root is None:
        return -1

    closest = root.value

    if abs(root.value - target) < abs(closest - target):
        closest = root.value
    elif abs(root.value - target) == abs(closest - target):
        closest = min(closest, root.value)

    if target < root.value:
        result = closest_value(root.left, target)
        if result == -1:
            return closest
        return min([closest, result], key=lambda x: (abs(x - target), x))

    if target > root.value:
        result = closest_value(root.right, target)
        if result == -1:
            return closest
        return min([closest, result], key=lambda x: (abs(x - target), x))

    return root.value


# Build BST
root = Node(4)
root.left = Node(2)
root.right = Node(5)
root.left.left = Node(1)
root.left.right = Node(3)

target = 3

print(closest_value(root, target))