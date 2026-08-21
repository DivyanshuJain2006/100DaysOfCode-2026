<h2 align="center">Week 10 Day 3 (19/08/2026)</h2>

## 1. Insert into a Binary Search Tree (LeetCode #701)
A problem that teaches BST traversal and insertion techniques by placing a new value into the correct position while preserving BST ordering. You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST. Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

This problem is commonly asked in interviews and helps build concepts like:
- BST properties (ordering)
- Recursive/iterative tree traversal
- Node insertion

which are important for solving BST-maintenance and construction problems.

**Your task:** Insert val into the BST and return the root node of the resulting tree.

### Input
The root of a binary search tree and an integer `val`, as described above.

**Constraints:**
- The number of nodes in the tree will be in the range [0, 10^4].
- `-10^8 <= Node.val <= 10^8`
- All the values Node.val are unique.
- `-10^8 <= val <= 10^8`
- It's guaranteed that val does not exist in the original BST.

### Output
Return the root of the BST after inserting val. Any valid resulting tree is accepted.

### Examples

**Input:**
```
root = [4,2,7,1,3], val = 5
```
**Output:**
```
[4,2,7,1,3,5]
```
**Note:** Other valid trees are also accepted.

---

**Input:**
```
root = [40,20,60,10,30,50,70], val = 25
```
**Output:**
```
[40,20,60,10,30,50,70,null,null,25]
```

---

**Input:**
```
root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
```
**Output:**
```
[4,2,7,1,3,5]
```

---

## 2. The Corporate Merger
Two companies are merging into a single organization. Each company stores its employee IDs in a Binary Search Tree (BST), where every node contains a unique employee ID. Before issuing new company badges, the HR department needs a complete list of all employees from both companies. The final list must: contain every employee ID that appears in either company; contain no duplicate IDs; and be sorted in ascending order.

This problem is commonly asked in interviews and helps build concepts like:
- BST in-order traversal
- Merging sorted sequences
- Duplicate removal

which are important for solving problems that combine multiple ordered tree structures into one sorted result.

**Your task:** Given two BSTs, return a sorted array containing all unique employee IDs from both trees.

### Input
The first line contains an integer `t` — the number of test cases. For each test case:
- An integer `n1`, followed by n1 integers representing `tree1` in level-order (compact encoding: a value of -1 denotes a null node, and null nodes do not contribute placeholder children).
- An integer `n2`, followed by n2 integers representing `tree2` in the same encoding.

**Constraints:**
- `1 <= t <= 200`
- `1 <= n1, n2 <= 1000`
- `-1 <= tree[i] <= 10^9` (-1 represents a null node)
- All non-null values within a single tree are distinct.
- The sum of n1 + n2 across all test cases does not exceed 2000.
- Employee IDs are non-negative (0 <= actual node values <= 10^9); -1 exclusively marks a null node and is never a real employee ID.

### Output
Return a sorted array of all unique employee IDs from both trees.

### Examples

**Input:**
```
n1 = 3
tree1 = [2, 1, 3]
n2 = 3
tree2 = [4, -1, 5]
```
**Output:**
```
[1, 2, 3, 4, 5]
```

---

**Input:**
```
n1 = 5
tree1 = [10, 5, 15, -1, 7]
n2 = 3
tree2 = [10, 8, 12]
```
**Output:**
```
[5, 7, 8, 10, 12, 15]
```

---

**Input:**
```
n1 = 1
tree1 = [1]
n2 = 1
tree2 = [1]
```
**Output:**
```
[1]
```

---
