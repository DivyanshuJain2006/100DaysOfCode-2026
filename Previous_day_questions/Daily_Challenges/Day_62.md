<h2 align="center">Week 9 Day 6 (15/08/2026)</h2>

## 1. Evaluate Boolean Binary Tree (LeetCode #2331)
A problem that teaches binary tree traversal and boolean-evaluation techniques by recursively applying logic gates encoded within tree nodes. You are given the root of a full binary tree with the following properties: leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True; non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND. The evaluation of a node is as follows: if the node is a leaf node, the evaluation is the value of the node, i.e. True or False; otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations. A full binary tree is a binary tree where each node has either 0 or 2 children. A leaf node is a node that has zero children.

This problem is commonly asked in interviews and helps build concepts like:
- Recursive tree traversal
- Boolean logic evaluation
- Bottom-up computation

which are important for solving expression-tree and logic-evaluation problems.

**Your task:** Return the boolean result of evaluating the root node.

### Input
The root of a full binary tree, as described above.

**Constraints:**
- The number of nodes in the tree is in the range [1, 1000].
- `0 <= Node.val <= 3`
- Every node has either 0 or 2 children.
- Leaf nodes have a value of 0 or 1.
- Non-leaf nodes have a value of 2 or 3.

### Output
Return the boolean result of evaluating the root node.

### Examples

**Input:**
```
root = [2,1,3,null,null,0,1]
```
**Output:**
```
true
```

---

**Input:**
```
root = [0]
```
**Output:**
```
false
```

---

## 2. The Heist
A thief is planning to rob houses in a neighborhood. The houses are arranged in the form of a binary tree, and each house contains a certain amount of money. However, there is a security system in place: if two directly connected houses (parent and child) are robbed on the same night, the alarm will be triggered. Because of this, the thief cannot rob both a house and any of its immediate children. The thief wants to maximize the total amount of money stolen while avoiding the alarm.

This problem is commonly asked in interviews and helps build concepts like:
- Tree DP (dynamic programming on trees)
- Recursive state tracking (rob vs. skip)
- Bottom-up optimization

which are important for solving tree-based dynamic programming and optimization problems.

**Your task:** Given the binary tree, find the maximum amount of money that can be robbed without robbing two directly connected houses.

### Input
An integer `n` and an array `tree` representing a complete binary tree in index form: for a node at index i, its left child is at index 2i+1 and its right child is at index 2i+2. A value of -1 at a given index means no node exists there.

**Constraints:**
- `1 <= n <= 1000`
- House values are 0 to 10000.
- A value of -1 at a given index denotes that no node exists there (see Input above).

### Output
Return the maximum amount of money that can be robbed.

### Examples

**Input:**
```
n = 7
tree = [3, 2, 3, -1, 3, -1, 1]
```
**Output:**
```
7
```

---

**Input:**
```
n = 7
tree = [3, 4, 5, 1, 3, -1, 1]
```
**Output:**
```
9
```

---

**Input:**
```
n = 1
tree = [10]
```
**Output:**
```
10
```

---
