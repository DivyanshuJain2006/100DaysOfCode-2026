<h2 align="center">Week 10 Day 4 (20/08/2026)</h2>

## 1. Delete Node in a BST (LeetCode #450)
A problem that teaches BST search and restructuring techniques by removing a node while preserving BST ordering. Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:
- Search for a node to remove.
- If the node is found, delete the node.

This problem is commonly asked in interviews and helps build concepts like:
- BST properties (ordering)
- Recursive/iterative tree traversal
- Node deletion and successor/predecessor replacement

which are important for solving BST-maintenance and restructuring problems.

**Your task:** Delete the node with the given key from the BST and return the root reference of the resulting tree.

### Input
The root of a binary search tree and an integer `key`, as described above.

**Constraints:**
- The number of nodes in the tree is in the range [0, 10^4].
- `-10^5 <= Node.val <= 10^5`
- Each node has a unique value.
- `root` is a valid binary search tree.
- `-10^5 <= key <= 10^5`

### Output
Return the root of the BST after deleting the node with the given key. Any valid resulting tree is accepted.

### Examples

**Input:**
```
root = [5,3,6,2,4,null,7], key = 3
```
**Output:**
```
[5,4,6,2,null,null,7]
```

---

**Input:**
```
root = [5,3,6,2,4,null,7], key = 0
```
**Output:**
```
[5,3,6,2,4,null,7]
```

---

**Input:**
```
root = [], key = 0
```
**Output:**
```
[]
```

---

## 2. The Balance Spectrum
You are given a sorted array of distinct integers. A Binary Search Tree is constructed using the following rules:
- Choose the middle element of the current segment as the root. If the segment length is even, choose the left-middle element.
- Recursively build the left subtree from the elements before the chosen root.
- Recursively build the right subtree from the elements after the chosen root.

This construction produces a tree with the minimum possible height. For every node in the tree, define its balance factor as: `height(right subtree) - height(left subtree)`. A node can have balance factor -1 (left taller by 1), 0 (equal height), or +1 (right taller by 1).

This problem is commonly asked in interviews and helps build concepts like:
- Balanced BST construction from a sorted array
- Recursive height computation
- Balance factor analysis (AVL-style reasoning)

which are important for solving problems involving self-balancing trees and structural tree properties.

**Your task:** Construct the tree and output three integers: the number of nodes with balance factor -1, the number of nodes with balance factor 0, and the number of nodes with balance factor +1.

### Input
An integer `n` and a sorted integer array `arr`, as described above.

**Constraints:**
- `1 <= n <= 100000`
- `1 <= arr[i] <= 10^9`
- `arr` is strictly increasing.

### Output
Output three space-separated integers: the counts of nodes with balance factor -1, 0, and +1, respectively.

### Examples

**Input:**
```
n = 7
arr = [1, 2, 3, 4, 5, 6, 7]
```
**Output:**
```
0 7 0
```

---

**Input:**
```
n = 1
arr = [42]
```
**Output:**
```
0 1 0
```

---
