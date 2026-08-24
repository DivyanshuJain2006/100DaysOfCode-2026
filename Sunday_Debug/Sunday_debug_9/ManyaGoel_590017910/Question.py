class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def inorder(root):
    if root is None:
        return

    # FIX: Changed Right -> Root -> Left to Left -> Root -> Right for correct inorder traversal.
    inorder(root.left)
    print(root.value, end=" ")
    inorder(root.right)

def height(root):
    # FIX: Changed the base case to 0 because height is counted by levels in the expected output.
    if root is None:
        return 0
    # FIX: Added 1 to count the current level and used max() to get the taller subtree.
    return 1 + max(height(root.left), height(root.right))

# Build the given binary tree.
root = Node("Eywa")
root.left = Node("Forest")
root.right = Node("Ocean")

root.left.right = Node("Mountains")
root.left.left = Node("Clan")

root.right.left = Node("Spirit Tree")
root.right.right = Node("Tulkun")

print("Neural Connections:")
inorder(root)
print("\nHeight:", height(root))