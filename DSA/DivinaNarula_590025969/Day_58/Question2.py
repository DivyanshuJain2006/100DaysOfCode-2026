# The Dispute Resolution

from collections import deque

class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


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


def find_lca(root, a, b):
    if root is None:
        return -1

    parent = {root.value: None}
    queue = deque([root])

    while queue and (a not in parent or b not in parent):
        node = queue.popleft()

        if node.left:
            parent[node.left.value] = node.value
            queue.append(node.left)

        if node.right:
            parent[node.right.value] = node.value
            queue.append(node.right)

    if a not in parent or b not in parent:
        return -1

    ancestors = set()

    while a is not None:
        ancestors.add(a)
        a = parent[a]

    while b not in ancestors:
        b = parent[b]

    return b


values = list(map(int, input("Enter tree in level order: ").split()))
a, b = map(int, input("Enter two employee IDs: ").split())

root = build_tree(values)
result = find_lca(root, a, b)

print("Lowest Common Ancestor:", result)