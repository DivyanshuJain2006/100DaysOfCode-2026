<h2 align="center">UPES ACM & ACM-W — 100 Days of Code — Day 58</h2>

## 1. Check Completeness of a Binary Tree
**Solution:** BFS the tree including nulls — if a real node ever appears after a null has been seen, it's not complete.
```python
from collections import deque

class Solution:
    def isCompleteTree(self, root: 'TreeNode') -> bool:
        if not root:
            return True

        queue = deque([root])
        seen_null = False

        while queue:
            node = queue.popleft()
            if node is None:
                seen_null = True
                continue
            if seen_null:
                return False
            queue.append(node.left)
            queue.append(node.right)

        return True
```
---
## 2. The Secret Passcodes
**Solution:** DFS each root-to-leaf path, XOR-toggling a 10-bit digit-parity bitmask; a leaf is valid if the mask has at most one bit set.
```python
import sys

def solve():
    data = sys.stdin.read().split()
    idx = 0
    t = int(data[idx]); idx += 1
    results = []

    for _ in range(t):
        n = int(data[idx]); idx += 1
        tree = list(map(int, data[idx:idx + n]))
        idx += n

        count = 0
        stack = [(0, 0)]

        while stack:
            node_idx, mask = stack.pop()
            if node_idx >= n or tree[node_idx] == -1:
                continue

            digit = tree[node_idx]
            mask ^= (1 << digit)

            left, right = 2 * node_idx + 1, 2 * node_idx + 2
            has_left = left < n and tree[left] != -1
            has_right = right < n and tree[right] != -1

            if not has_left and not has_right:
                if bin(mask).count('1') <= 1:
                    count += 1
            else:
                if has_left:
                    stack.append((left, mask))
                if has_right:
                    stack.append((right, mask))

        results.append(str(count))

    print("\n".join(results))

if __name__ == "__main__":
    solve()
```
