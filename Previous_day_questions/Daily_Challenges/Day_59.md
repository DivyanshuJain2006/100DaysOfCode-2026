<h2 align="center">Week 9 Day 3 (12/08/2026)</h2>

## 1. Check Completeness of a Binary Tree (LeetCode #958)
A problem that teaches binary tree traversal and structural validation techniques by verifying whether a tree is fully packed level by level. Given the root of a binary tree, determine if it is a complete binary tree. In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.

This problem is commonly asked in interviews and helps build concepts like:
- Level-order traversal (BFS)
- Structural validation
- Null-node handling

which are important for solving tree-shape and completeness-verification problems.

**Your task:** Return true if the binary tree is a complete binary tree, otherwise return false.

### Input
The root of a binary tree, as described above.

**Constraints:**
- The number of nodes in the tree is in the range [1, 100].
- `1 <= Node.val <= 1000`

### Output
Return true if the tree is a complete binary tree, otherwise return false.

### Examples

**Input:**
```
root = [1,2,3,4,5,6]
```
**Output:**
```
true
```

---

**Input:**
```
root = [1,2,3,4,5,null,7]
```
**Output:**
```
false
```

---

## 2. The Secret Passcodes
A bank vault generates passcodes using a binary tree of digit pads. Each node contains a digit from 0 to 9. A passcode is formed by starting at the root and following a path to a leaf node, writing down every digit encountered along the path. A passcode is considered valid if its digits can be rearranged to form a palindrome. A sequence can be rearranged into a palindrome if at most one digit appears an odd number of times.

This problem is commonly asked in interviews and helps build concepts like:
- Binary tree construction from heap-array input
- Root-to-leaf path traversal
- Bitmask/parity tracking for palindrome checks

which are important for solving path-based counting problems with a parity constraint.

**Your task:** Count the number of root-to-leaf paths that form a valid passcode.

### Input
The first line contains an integer `t`, the number of test cases. For each test case:
- The first line contains an integer `n`, the size of the array.
- The second line contains `n` space-separated integers representing the tree in heap-array (index-based) format, where for a node at index i, its left child is at index 2i+1 and its right child is at index 2i+2. A value of -1 denotes a missing node.

**Constraints:**
- `1 <= t <= 200`
- `1 <= n <= 100000`
- `0 <= tree[i] <= 9` (-1 represents a null node)
- The sum of n over all test cases does not exceed 100000.

### Output
For each test case, output a single integer — the number of root-to-leaf paths whose digits can be rearranged into a palindrome — on its own line.

### Examples

**Input:**
```
t = 1
n = 7
tree = [2, 3, 1, 3, 1, -1, 1]
```
**Output:**
```
2
```

---

**Input:**
```
t = 1
n = 3
tree = [1, 1, 1]
```
**Output:**
```
2
```

---

**Input:**
```
t = 1
n = 1
tree = [5]
```
**Output:**
```
1
```

---
