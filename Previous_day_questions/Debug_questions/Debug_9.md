# UPES ACM & ACM-W 100 Days of Code

**Day: 63**
**UPES ACM & ACM-W 100 Days of Code Platform**

---

## Debug 9: The Tree of Souls

### Story

After a surprise attack by Quaritch, Jake Sully finds himself separated from one of his daughters deep within Pandora. Unable to locate her through scouting, Jake turns to the Tree of Souls connected to Pandora's vast neural network, allowing the Na'vi to trace connections across generations.

But something is wrong. When Jake attempts to navigate the network, entire branches disappear. Some paths that should lead left suddenly lead right. Even Eywa's estimate of the tree's depth seems incorrect.

You are given a buggy Binary Tree in Python that should: build a binary tree, perform an inorder traversal, and calculate the height of the tree. Fix all logical bugs.

**Neural Bond Requirement:** Recursive traversal and recursive height calculation must be preserved. Converting to iterative traversal using stacks or queues is not allowed.

**Hint:** Jake believes corruption has affected the direction of some neural paths, the ability to explore certain branches, and Eywa's calculation of network depth.

---

### What the Code Must Do

- Build the given binary tree structure exactly as described.
- Perform a correct inorder traversal (Left → Root → Right) and print the node values in the correct order.
- Correctly calculate the height of the tree using recursion.
- Preserve recursion throughout - no iterative (stack/queue-based) substitutions allowed.
- Visit all nodes during traversal.

---

### Buggy Code

```python
class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def inorder(root):
    if root is None:
        return
    inorder(root.right)
    print(root.value, end=" ")
    inorder(root.left)

def height(root):
    if root is None:
        return 0
    return max(height(root.left), height(root.right))

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

### Expected Output

```
Neural Connections:
Clan Forest Mountains Eywa Spirit Tree Ocean Tulkun
Height: 3
```

---

### Constraints

- 1 ≤ N ≤ 10⁵
- Tree is a Binary Tree (not necessarily a BST).
- Recursive implementation must be preserved — no iterative substitution.
- All nodes must be visited during traversal.
- Height must be calculated correctly.
