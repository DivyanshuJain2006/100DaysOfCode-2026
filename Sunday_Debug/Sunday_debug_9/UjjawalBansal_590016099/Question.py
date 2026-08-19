class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def inorder(root):
    if root is None:
        return
    # FIX: Reordered the recursive calls to follow Left -> Root -> Right, which is the correct inorder traversal.
    inorder(root.left)
    print(root.value, end=" ")
    inorder(root.right)
def height(root):
    # FIX: Kept the base case as 0 so the height is counted by levels, matching the required output.
    if root is None:
        return 0
    # FIX: Added 1 for the current level and used max() to choose the deeper subtree.
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