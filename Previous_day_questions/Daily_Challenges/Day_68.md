<h2 align="center">100 Days of Code — Day 68</h2>

## 1. Balance a Binary Search Tree (LeetCode #1382)

A problem that teaches BST-to-balanced-BST conversion techniques by rebuilding a tree so that its structure satisfies the balance property. Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

This problem is commonly asked in interviews and helps build concepts like:
- In-order traversal to extract sorted values
- Recursive construction of a height-balanced BST
- Divide-and-conquer tree building

which are important for solving problems involving self-balancing trees and BST reconstruction.

**Your task:** Return a balanced binary search tree with the same node values as the input tree.

### Input
The root of a binary search tree, as described above.

**Constraints:**
- The number of nodes in the tree is in the range [1, 10^4].
- `1 <= Node.val <= 10^5`

### Output
Return the root of a balanced BST with the same node values. Any valid balanced tree is accepted.

### Examples

**Input:**
```
root = [1,null,2,null,3,null,4,null,null]
```
**Output:**
```
[2,1,3,null,null,null,4]
```
*Note: Other valid balanced trees are also accepted.*

---

**Input:**
```
root = [2,1,3]
```
**Output:**
```
[2,1,3]
```

---

## 2. The Franchise Audit

A retail chain organizes its stores in a hierarchical structure represented as a binary tree. Each node contains a unique store ID. According to company policy, every regional structure should follow the rules of a Binary Search Tree (BST):
- Every store in the left subtree must have a smaller ID than the current store.
- Every store in the right subtree must have a larger ID than the current store.
- Both subtrees must also be valid BSTs.

However, over time some regional managers have reorganized their branches incorrectly, causing parts of the hierarchy to violate BST rules. The auditor wants to find the largest region of the hierarchy that still forms a valid BST.

This problem is commonly asked in interviews and helps build concepts like:
- Recursive subtree validation
- Bottom-up range propagation (min/max tracking)
- BST property verification

which are important for solving problems involving tree validation and hierarchical data auditing.

**Your task:** Return the size (number of nodes) of the largest subtree that is a valid Binary Search Tree.

### Input
An integer `n` and a level-order array `tree`, as described above. The value `-1` represents a null node.

**Constraints:**
- `1 <= t <= 200`
- `1 <= n <= 1000`
- `-1 <= tree[i] <= 10^9` (`-1` represents a null node)
- All non-null node values are distinct.
- The sum of `n` across all test cases does not exceed 1000.

### Output
Return the size of the largest subtree that is a valid Binary Search Tree.

### Examples

**Input:**
```
n = 7
tree = [10, 5, 15, 1, 8, -1, 7]
```
**Output:**
```
3
```

---

**Input:**
```
n = 7
tree = [5, 2, 8, 1, 3, 6, 9]
```
**Output:**
```
7
```

---

**Input:**
```
n = 5
tree = [1, 2, 3, 4, 5]
```
**Output:**
```
1
```
