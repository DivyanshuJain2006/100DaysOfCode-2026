# UPES ACM & ACM-W 100 Days of Code

**Day: 63**
**UPES ACM & ACM-W 100 Days of Code Platform**

---

## Debug 9: The Tree of Souls — Solution

### Bugs Identified

1. **`inorder()` traversal order was reversed.**
   The buggy code called `inorder(root.right)` before printing, and `inorder(root.left)` after — this performs a **Right → Root → Left** traversal instead of the required **Left → Root → Right**.
   **Fix:** Swap the recursive calls so `inorder(root.left)` comes first and `inorder(root.right)` comes last.

2. **`height()` did not account for the current node's level.**
   The buggy code returned `max(height(root.left), height(root.right))` without adding 1 for the current node, so it undercounts the depth of the tree.
   **Fix:** Add `1 +` to the max of the two recursive calls: `1 + max(height(root.left), height(root.right))`.

---

### Fixed Code

```python
class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def inorder(root):
    if root is None:
        return
    # inorder(root.right)          # BUG: was visiting right before left
    inorder(root.left)             # FIX: visit left subtree first
    print(root.value, end=" ")
    # inorder(root.left)           # BUG: was visiting left after right
    inorder(root.right)            # FIX: visit right subtree last

def height(root):
    if root is None:
        return 0
    # return max(height(root.left), height(root.right))   # BUG: missing +1 for current node
    return 1 + max(height(root.left), height(root.right))  # FIX: add 1 to count current level

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
```

---

### Output

```
Neural Connections:
Clan Forest Mountains Eywa Spirit Tree Ocean Tulkun
Height: 3
```

---

### Explanation

- **Inorder Traversal (Left → Root → Right):**
  Starting from `Eywa`, we go all the way left first (`Forest → Clan`), print `Clan`, back up to print `Forest`, then go right to `Mountains` and print it, back up to print `Eywa` (the root), then move to the right subtree (`Ocean`), printing `Spirit Tree`, `Ocean`, and finally `Tulkun`.
  This matches the tree structure exactly and produces: `Clan Forest Mountains Eywa Spirit Tree Ocean Tulkun`.

- **Height Calculation:**
  Height of a tree = 1 (for the current node) + the height of its taller subtree.
  - `Clan` and `Mountains` are leaf nodes → height 1
  - `Forest` = 1 + max(height(Clan), height(Mountains)) = 1 + max(1,1) = 2
  - `Spirit Tree` and `Tulkun` are leaf nodes → height 1
  - `Ocean` = 1 + max(height(Spirit Tree), height(Tulkun)) = 1 + max(1,1) = 2
  - `Eywa` (root) = 1 + max(height(Forest), height(Ocean)) = 1 + max(2,2) = 3

  Final height = **3**, matching the expected output.
