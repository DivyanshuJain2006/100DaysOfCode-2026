<h2 align="center">Week 9 Day 2 (11/08/2026)</h2>

## 1. Count Complete Tree Nodes (LeetCode #222)
A problem that teaches binary tree property exploitation and binary search techniques by counting nodes without a full traversal. Given the root of a complete binary tree, return the number of the nodes in the tree. According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h. Design an algorithm that runs in less than O(n) time complexity.

This problem is commonly asked in interviews and helps build concepts like:
- Complete binary tree properties
- Binary search on tree height
- Sub-linear counting techniques

which are important for solving problems that exploit structural guarantees to beat naive traversal.

**Your task:** Return the number of nodes in the complete binary tree, using an algorithm that runs in less than O(n) time.

### Input
The root of a complete binary tree, as described above.

**Constraints:**
- The number of nodes in the tree is in the range [0, 5 x 10^4].
- `0 <= Node.val <= 5 x 10^4`
- The tree is guaranteed to be complete.

### Output
Return the number of nodes in the tree.

### Examples

**Input:**
```
root = [1,2,3,4,5,6]
```
**Output:**
```
6
```

---

**Input:**
```
root = []
```
**Output:**
```
0
```

---

**Input:**
```
root = [1]
```
**Output:**
```
1
```

---

## 2. The Dispute Resolution
A company stores its management hierarchy as a binary tree. Each node represents an employee, and every employee has a unique ID. When two employees file a dispute, company policy requires the case to be escalated to their lowest common manager. The lowest common manager is the lowest employee in the hierarchy who is an ancestor of both employees. Before resolving the dispute, the system must verify that both employees actually exist in the company hierarchy. If either employee is missing, the dispute cannot be processed.

This problem is commonly asked in interviews and helps build concepts like:
- Binary tree construction from level-order input
- Lowest Common Ancestor (LCA)
- Existence validation before traversal

which are important for solving hierarchy-based ancestor-query problems.

**Your task:** Given a binary tree and two employee IDs a and b, find the ID of their Lowest Common Ancestor (LCA). If either employee does not exist in the tree, return -1.

### Input
The first line contains an integer `t`, the number of test cases. For each test case:
- An integer `n`, the size of the level-order array `tree` (including -1 entries for missing employees)
- The array `tree` itself, representing the hierarchy in level order: for a node at index i, its children are at indices 2i+1 and 2i+2, and -1 means no employee exists at that position
- Two integers `a` and `b`, the IDs of the employees involved in the dispute

**Constraints:**
- `1 <= t <= 200`
- `1 <= n <= 1000`
- All employee IDs are unique.
- `-1 <= tree[i] <= 10^9` (-1 represents a null node)
- `1 <= a, b <= 10^9`
- The sum of n across all test cases does not exceed 1000.

### Output
Return the ID of the Lowest Common Ancestor of employees a and b, or -1 if either does not exist in the tree.

### Examples

**Input:**
```
n = 11
tree = [3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4]
a = 5
b = 1
```
**Output:**
```
3
```

---

**Input:**
```
n = 11
tree = [3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4]
a = 6
b = 4
```
**Output:**
```
5
```

---

**Input:**
```
n = 3
tree = [1, 2, 3]
a = 2
b = 99
```
**Output:**
```
-1
```

---
