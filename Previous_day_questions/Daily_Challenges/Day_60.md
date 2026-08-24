<h2 align="center">Week 9 Day 60</h2>

## 1. Diameter of Binary Tree

A problem that teaches tree traversal and recursive reasoning techniques by computing the longest path between any two nodes in a binary tree.

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root. The length of a path between two nodes is represented by the number of edges between them.

This problem is commonly asked in interviews and helps build concepts like:
- Binary tree traversal
- Recursive depth calculation
- Divide and conquer reasoning
- Optimization techniques

which are important for solving tree-based data-processing problems efficiently.

**Your task:** Return the length of the diameter of the binary tree.

### Input
The root of a binary tree, as described above.

**Constraints:**
- The number of nodes in the tree is in the range [1, 10^4].
- -100 <= Node.val <= 100

### Output
Return the length of the diameter of the binary tree.

### Examples

**Input:**
```
root = [1,2,3,4,5]
```
**Output:**
```
3
```

---

**Input:**
```
root = [1,2]
```
**Output:**
```
1
```

---

## 2. The Mountain Expedition

A problem that introduces tree traversal techniques and teaches how to track constraints along a root-to-node path while processing a binary tree.

A mountaineering club is exploring a mountain range. The campsites are arranged in the form of a binary tree, where each node represents a campsite and its value represents the altitude of that campsite.

A campsite is considered safe if its altitude is greater than or equal to every campsite encountered on the path from the summit (root) to that campsite. In other words, a campsite is safe if no campsite above it on the path has a higher altitude.

This problem appears frequently in interviews and real-world applications like terrain analysis, path validation systems, monitoring pipelines, and hierarchical data processing. The challenge involves traversing the tree efficiently while maintaining the maximum altitude seen so far along each path.

This teaches:
- Binary tree traversal
- Path-based constraint tracking
- Recursive/iterative state passing
- Optimization techniques

which are essential for efficient tree-based data processing and interview problem solving.

**Your task:** Given the binary tree, return the number of safe campsites.

### Input
An integer n and a level-order array tree, as described above.

**Constraints:**
- 1 <= t <= 200
- 1 <= n <= 1000
- -1 <= tree[i] <= 10000 (-1 represents a null node)
- The sum of n across all test cases does not exceed 1000.

### Output
Return the number of safe campsites in the tree.

### Examples

**Input:**
```
n = 7
tree = [3, 1, 4, 3, -1, 1, 5]
```
**Output:**
```
4
```

---

**Input:**
```
n = 3
tree = [3, 3, -1]
```
**Output:**
```
2
```

---

**Input:**
```
n = 3
tree = [1, 2, 3]
```
**Output:**
```
3
```
