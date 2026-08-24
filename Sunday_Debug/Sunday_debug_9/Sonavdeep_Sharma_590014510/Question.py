class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def inorder(root):
    if root is None:
        return

    inorder(root.left)
    print(root.data, end=" ")
    inorder(root.right)


def height(root):
    if root is None:
        return -1

    return 1 + max(height(root.left), height(root.right))



root = Node("Spirit")

root.left = Node("Forest")
root.right = Node("Tree")

root.left.left = Node("Clan")
root.left.right = Node("Mountains")

root.left.right.right = Node("Eywa")

root.right.left = Node("Ocean")
root.right.right = Node("Tulkun")


print("Neural Connections:")
inorder(root)

print()
print("Height:", height(root))