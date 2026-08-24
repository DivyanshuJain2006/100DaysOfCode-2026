<h2 align="center">Week 9 Day 1 (10/08/2026)</h2>

## 1. Sum of Left Leaves (LeetCode #404)
A problem that teaches binary tree traversal techniques by identifying and summing a specific category of leaf nodes. Given the root of a binary tree, return the sum of all left leaves. A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

This problem is commonly asked in interviews and helps build concepts like:
- Tree traversal (DFS/BFS)
- Leaf node identification
- Parent-child relationship tracking

which are important for solving tree-structure and node-classification problems.

**Your task:** Return the sum of all left leaves in the binary tree.

### Input
The root of a binary tree, as described above.

**Constraints:**
- The number of nodes in the tree is in the range [1, 1000].
- `-1000 <= Node.val <= 1000`

### Output
Return the sum of all left leaves in the tree.

### Examples

**Input:**
```
root = [3,9,20,null,null,15,7]
```
**Output:**
```
24
```

---

**Input:**
```
root = [1]
```
**Output:**
```
0
```

---

## 2. The Twin Warehouses
A logistics company operates two warehouses. Each warehouse is organized as a binary tree of storage zones. Every zone contains a value representing the type of inventory stored there. The operations manager wants to know whether Warehouse B is a mirror image of Warehouse A. Two trees are considered mirror images if their root nodes contain the same value, the left child of a node in the first tree matches the right child of the corresponding node in the second tree, and the right child of a node in the first tree matches the left child of the corresponding node in the second tree.

Both warehouse layouts are given in level-order representation. A missing child is represented by -1 in the level-order array. The array follows complete-tree indexing: for a node at index i, its left child is at index 2i+1 and its right child is at index 2i+2. If a child's index falls outside the array (i.e., the array is shorter than the index requires), that child is also treated as missing.

This problem is commonly asked in interviews and helps build concepts like:
- Binary tree construction from level-order input
- Recursive tree comparison
- Mirror/symmetry checking

which are important for solving structural-equality and tree-symmetry problems.

**Your task:** Determine whether the second warehouse is a mirror image of the first warehouse. Print YES if the warehouses are mirror images, otherwise print NO.

### Input
The first line contains an integer `t`, the number of test cases. For each test case: the first line contains an integer `n1` followed by `n1` space-separated integers representing `warehouse1` in level-order; the next line contains an integer `n2` followed by `n2` space-separated integers representing `warehouse2` in level-order.

**Constraints:**
- `1 <= t <= 200`
- `1 <= n1, n2 <= 1000`
- `warehouse[i] = -1` (representing a missing child) or `1 <= warehouse[i] <= 10^9`
- The sum of n1 + n2 across all test cases does not exceed 2000.

### Output
Print YES if the second warehouse is a mirror image of the first warehouse, otherwise print NO.

### Examples

**Input:**
```
n1 = 3
warehouse1 = [1, 2, 3]
n2 = 3
warehouse2 = [1, 3, 2]
```
**Output:**
```
YES
```

---

**Input:**
```
n1 = 3
warehouse1 = [1, 2, 3]
n2 = 3
warehouse2 = [1, 2, 3]
```
**Output:**
```
NO
```

---

**Input:**
```
n1 = 1
warehouse1 = [5]
n2 = 1
warehouse2 = [5]
```
**Output:**
```
YES
```

---
