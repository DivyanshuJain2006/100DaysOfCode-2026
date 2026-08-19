class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def insert(root, value):
    if root is None:
        return Node(value)

    if value < root.value:
        root.left = insert(root.left, value)
    else:
        root.right = insert(root.right, value)

    return root


def closest_value(root, target):
    closest = root.value

    while root:
        if abs(root.value - target) < abs(closest - target):
            closest = root.value
        elif abs(root.value - target) == abs(closest - target):
            closest = min(closest, root.value)

        if target < root.value:
            root = root.left
        elif target > root.value:
            root = root.right
        else:
            return root.value

    return closest


# Take tree values in one line
values = list(map(int, input("Enter tree values: ").split()))

# Take target
target = int(input("Enter target: "))

# Create BST
root = None

for value in values:
    if value != -1:
        root = insert(root, value)

# Find closest value
result = closest_value(root, target)

print("Closest value:", result)