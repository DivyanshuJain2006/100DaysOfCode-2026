<h2 align="center">Week 10 Day 1 (17/08/2026)</h2>

## 1. Range Sum of BST (LeetCode #938)
A problem that teaches binary search tree traversal and pruning techniques by summing node values that fall within a given range. Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

This problem is commonly asked in interviews and helps build concepts like:
- BST traversal
- Range-based pruning
- Recursive sum accumulation

which are important for solving efficient range-query problems on ordered tree structures.

**Your task:** Return the sum of values of all nodes with a value in the inclusive range [low, high].

### Input
The root of a binary search tree and two integers `low` and `high`, as described above.

**Constraints:**
- The number of nodes in the tree is in the range [1, 2 x 10^4].
- `1 <= Node.val <= 10^5`
- `1 <= low <= high <= 10^5`
- All Node.val are unique.

### Output
Return the sum of values of all nodes with a value in the range [low, high].

### Examples

**Input:**
```
root = [10,5,15,3,7,null,18], low = 7, high = 15
```
**Output:**
```
32
```

---

**Input:**
```
root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
```
**Output:**
```
23
```

---

## 2. The Conference Room
A tech campus organizes its meeting rooms using a Binary Search Tree (BST). Each node in the tree represents a meeting room, and the value stored in the node is the room number. Two employees have booked rooms a and b. To reach their rooms, both employees start from the main lobby (the root of the BST) and follow the path down the tree. The facilities team wants to find the deepest room that lies on both paths. This room is called the Lowest Common Ancestor (LCA) of rooms a and b. A room can be considered an ancestor of itself.

This problem is commonly asked in interviews and helps build concepts like:
- BST properties (ordering)
- Lowest Common Ancestor (LCA)
- Path comparison

which are important for solving efficient ancestor-query problems using BST ordering.

**Your task:** Given a BST and two room numbers a and b, find the value of their Lowest Common Ancestor. It is guaranteed that both room numbers exist in the BST.

### Input
An integer `t` denoting the number of test cases. For each test case: an integer `n`, a level-order array `tree`, and two integers `a` and `b`, as described above.

**Constraints:**
- `1 <= t <= 200`
- `1 <= n <= 1000`
- `0 <= tree[i] <= 10^9` (-1 represents a null node)
- All non-null values are distinct.
- a and b are guaranteed to exist in the tree.
- The sum of n over all test cases does not exceed 1000.

### Output
Return the value of the Lowest Common Ancestor of rooms a and b.

### Examples

**Input:**
```
n = 7
tree = [6, 2, 8, 0, 4, 7, 9]
a = 2
b = 8
```
**Output:**
```
6
```

---

**Input:**
```
n = 7
tree = [6, 2, 8, 0, 4, 7, 9]
a = 2
b = 4
```
**Output:**
```
2
```

---

**Input:**
```
n = 3
tree = [2, 1, 3]
a = 1
b = 3
```
**Output:**
```
2
```

---
