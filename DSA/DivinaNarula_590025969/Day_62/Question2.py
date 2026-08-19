# The Heist

from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def build_tree(values):
    if not values or values[0] == -1:
        return None

    root = TreeNode(values[0])
    queue = deque([root])
    i = 1

    while queue and i < len(values):
        node = queue.popleft()

        if values[i] != -1:
            node.left = TreeNode(values[i])
            queue.append(node.left)
        i += 1

        if i < len(values) and values[i] != -1:
            node.right = TreeNode(values[i])
            queue.append(node.right)
        i += 1

    return root


def max_rob(root):
    def dfs(node):
        if not node:
            return 0, 0

        left_rob, left_skip = dfs(node.left)
        right_rob, right_skip = dfs(node.right)

        rob = node.val + left_skip + right_skip
        skip = max(left_rob, left_skip) + max(right_rob, right_skip)

        return rob, skip

    return max(dfs(root))


values = list(map(int, input("Enter Tree : ").split()))
root = build_tree(values)

print(max_rob(root))