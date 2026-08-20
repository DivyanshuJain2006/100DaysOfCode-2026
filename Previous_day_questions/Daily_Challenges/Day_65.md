<h2 align="center">Week 10 Day 2 (18/08/2026)</h2>

## 1. Find Mode in Binary Search Tree (LeetCode #501)
A problem that teaches BST traversal and frequency-counting techniques by identifying the most common value(s) in a tree that allows duplicates. Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it. If the tree has more than one mode, return them in any order. Assume a BST is defined as follows: the left subtree of a node contains only nodes with keys less than or equal to the node's key; the right subtree of a node contains only nodes with keys greater than or equal to the node's key; and both the left and right subtrees must also be binary search trees.

This problem is commonly asked in interviews and helps build concepts like:
- In-order BST traversal
- Frequency counting
- Consecutive-value comparison

which are important for solving frequency-based queries on ordered tree structures.

**Your task:** Return all the modes (most frequently occurring elements) in the BST, in any order.

### Input
The root of a binary search tree with duplicates, as described above.

**Constraints:**
- The number of nodes in the tree is in the range [1, 10^4].
- `-10^5 <= Node.val <= 10^5`

### Output
Return an array of all the modes in the BST.

**Follow up:** Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

### Examples

**Input:**
```
root = [1,null,2,2]
```
**Output:**
```
[2]
```

---

**Input:**
```
root = [0]
```
**Output:**
```
[0]
```

---

## 2. The Thermostat
A smart building stores all available temperature presets in a Binary Search Tree (BST). Each node in the tree represents a preset temperature. When a resident enters a desired temperature, the thermostat must select the preset that is closest to the requested value. If two preset temperatures are equally close to the target, the thermostat chooses the smaller temperature to save energy.

This problem is commonly asked in interviews and helps build concepts like:
- BST properties (ordering)
- Closest-value search
- Tie-breaking logic

which are important for solving nearest-value lookup problems on ordered tree structures.

**Your task:** Given a BST and a target temperature, find the preset value that is closest to the target. If multiple presets are equally close, return the smaller one.

### Input
The first line contains an integer `T`, the number of test cases. For each test case:
- An integer `n`, the number of entries in the tree array.
- A level-order array `tree` of size n, using 1-indexed heap-style indexing: the children of the node at index i are at indices 2i and 2i+1. A value of -1 denotes a null node.
- A decimal value `target`, the requested temperature.

**Constraints:**
- `1 <= T <= 200`
- `1 <= n <= 1000`
- `-1 <= tree[i] <= 10^9` (-1 represents a null node)
- All non-null values are distinct.
- target has at most 2 decimal places.
- The sum of n across all test cases does not exceed 1000.

### Output
Return the preset value closest to target, choosing the smaller value in case of a tie.

### Examples

**Input:**
```
T = 1
n = 7
tree = [4, 2, 5, 1, 3, -1, -1]
target = 3
```
**Output:**
```
3
```

---

**Input:**
```
T = 1
n = 7
tree = [4, 2, 5, 1, 3, -1, -1]
target = 3.7
```
**Output:**
```
4
```

---

**Input:**
```
T = 1
n = 3
tree = [1, -1, 3]
target = 2
```
**Output:**
```
1
```

---
