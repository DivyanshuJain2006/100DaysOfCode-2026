class Node:
    # A single node in the binary tree — stores a value and links to its two children.
    def __init__(self, value):
        self.value = value   # the data held by this node (e.g. "Eywa")
        self.left = None     # pointer to the left child (None if there isn't one)
        self.right = None    # pointer to the right child (None if there isn't one)

def inorder(root):
    # Recursive inorder traversal: Left -> Root -> Right.
    if root is None:            # base case: reached an empty branch, stop recursing
        return
    inorder(root.left)          # step 1: recurse into the left subtree first
    print(root.value, end=" ")  # step 2: process (print) the current node
    inorder(root.right)         # step 3: recurse into the right subtree last

def height(root):
    # Recursive height calculation: number of nodes on the longest path
    # from this node down to a leaf.
    if root is None:            # base case: an empty subtree contributes 0 height
        return 0
    # current node counts as 1, plus whichever child subtree is taller
    return 1 + max(height(root.left), height(root.right))

# ----- Build the tree -----
root = Node("Eywa")                                  # root of the tree
root.left = Node("Forest");  root.right = Node("Ocean")   # Eywa's two children
root.left.right = Node("Mountains")                  # Forest's right child
root.left.left  = Node("Clan")                       # Forest's left child
root.right.left = Node("Spirit Tree"); root.right.right = Node("Tulkun")  # Ocean's children

# ----- Run traversal and height calculation -----
print("Neural Connections:")
inorder(root)                   # prints all node values in Left-Root-Right order
print("\nHeight:", height(root))  # prints the height of the whole tree
