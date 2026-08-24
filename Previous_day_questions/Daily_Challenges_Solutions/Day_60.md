<h2 align="center">Week 9 Day 60 (11/08/2026)</h2>

## 1. Diameter of Binary Tree (LeetCode #543)

### Solution

```python
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: 'TreeNode') -> int:
        self.diameter = 0

        def height(node):
            if not node:
                return 0
            left_h = height(node.left)
            right_h = height(node.right)
            # update diameter using this node as the "peak"
            self.diameter = max(self.diameter, left_h + right_h)
            # return height of subtree rooted at node
            return 1 + max(left_h, right_h)

        height(root)
        return self.diameter
```

How it works: for any node, the longest path passing through it equals the height of its left subtree plus the height of its right subtree — that node acts as the "peak" of the path. A single post-order DFS computes each subtree's height bottom-up while, at every node, checking whether `left_h + right_h` beats the best diameter seen so far. Since every node is tested as a potential peak exactly once, the true diameter (which must peak at some node) is guaranteed to be found.

Complexity: O(n) time, O(h) extra space for the recursion stack, where `h` is the tree height.

Trace on Sample 1 `[1,2,3,4,5]`:

```
        1
       / \
      2   3
     / \
    4   5
```

Left subtree height = 2, right subtree height = 1 → diameter = 3 ✅

---

## 2. The Mountain Expedition

### Solution

```python
def countSafeCampsites(n, tree):
    if n == 0 or tree[0] == -1:
        return 0

    count = 0

    def dfs(idx, max_so_far):
        nonlocal count
        if idx >= n or tree[idx] == -1:
            return

        val = tree[idx]
        if val >= max_so_far:
            count += 1
            new_max = val          # this node becomes the new highest on the path
        else:
            new_max = max_so_far   # unsafe node doesn't raise the bar

        dfs(2 * idx + 1, new_max)  # left child
        dfs(2 * idx + 2, new_max)  # right child

    dfs(0, float('-inf'))
    return count


# ---- Test cases ----
print(countSafeCampsites(7, [3, 1, 4, 3, -1, 1, 5]))  # Expected: 4
print(countSafeCampsites(3, [3, 3, -1]))              # Expected: 2
print(countSafeCampsites(3, [1, 2, 3]))               # Expected: 3
```

How it works: a campsite is "safe" when its altitude is greater than or equal to every ancestor on its root-to-node path — equivalently, it's at least as high as the running maximum altitude seen so far along that path. The tree is stored as a heap-style array (index `i`'s children live at `2i+1` and `2i+2`, with `-1` marking a missing node), so a plain DFS by index works without building actual tree objects. Each call carries `max_so_far`: if the current value meets or beats it, the node is counted safe and becomes the new running max for its children; otherwise the running max is simply passed through unchanged.

Complexity: O(n) time, O(h) extra space for the recursion stack, where `h` is the tree height.

Trace on Sample 1 `n=7, tree=[3,1,4,3,-1,1,5]`:

```
            3(idx0)
           /       \
       1(idx1)    4(idx2)
      /     \     /    \
  3(idx3) null  1(idx5) 5(idx6)
```

- idx0=3, max=-inf → safe, max=3
- idx1=1 < 3 → not safe, max stays 3
- idx2=4 ≥ 3 → safe, max=4
- idx3=3, from idx1's max=3 → 3≥3 → safe
- idx4=-1 → skip (null)
- idx5=1, from idx2's max=4 → 1<4 → not safe
- idx6=5, from idx2's max=4 → 5≥4 → safe

Safe: {3, 4, 3, 5} → 4 ✅
