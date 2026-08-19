class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def inorder(root):
    if root is None: 
        return
    
    # Corrected: Left -> Root -> Right
    inorder(root.left)      
    print(root.value, end=" ")
    inorder(root.right)

def height(root):
    if root is None: 
        return 0
        
    # Corrected: Added 1 to account for the current node
    return 1 + max(height(root.left), height(root.right))

# Build the tree
root = Node("Eywa")
root.left = Node("Forest")
root.right = Node("Ocean")

root.left.left  = Node("Clan")
root.left.right = Node("Mountains")

root.right.left = Node("Spirit Tree")
root.right.right = Node("Tulkun")

print("Neural Connections:")
inorder(root)
print("\nHeight:", height(root))