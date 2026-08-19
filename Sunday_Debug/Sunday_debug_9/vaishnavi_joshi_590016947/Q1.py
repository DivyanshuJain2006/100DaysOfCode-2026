class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def inorder(root):
    if root is None:
        return

    inorder(root.left)
    print(root.value, end=" ")
    inorder(root.right)


def height(root):
    if root is None:
        return 0

    return 1 + max(height(root.left), height(root.right))


# Build the tree
root = Node("Eywa")

root.left = Node("Forest")
root.right = Node("Ocean")

root.left.left = Node("Mountains")
root.left.right = Node("Clan")

root.left.right.left = Node("Na'vi")
root.left.right.right = Node("Spirit Tree")

root.right.right = Node("Tulkun")


# Output
print("Neural Connections:")
inorder(root)

print("\nHeight:", height(root))
