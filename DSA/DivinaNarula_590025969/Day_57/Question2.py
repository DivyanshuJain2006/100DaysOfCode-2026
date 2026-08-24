# The Twin Warehouses

from collections import deque

def build_tree(values):
    if not values or values[0] == -1:
        return None

    root = [values[0], None, None]
    queue = deque([root])
    i = 1

    while queue and i < len(values):
        node = queue.popleft()

        if i < len(values) and values[i] != -1:
            node[1] = [values[i], None, None]
            queue.append(node[1])
        i += 1

        if i < len(values) and values[i] != -1:
            node[2] = [values[i], None, None]
            queue.append(node[2])
        i += 1

    return root


def are_mirror(root1, root2):
    if root1 is None or root2 is None:
        return root1 is root2

    queue = deque([(root1, root2)])

    while queue:
        a, b = queue.popleft()

        if a[0] != b[0]:
            return False

        if (a[1] is None) != (b[2] is None):
            return False

        if (a[2] is None) != (b[1] is None):
            return False

        if a[1] is not None:
            queue.append((a[1], b[2]))

        if a[2] is not None:
            queue.append((a[2], b[1]))

    return True


tree1 = list(map(int, input("Enter warehouse1: ").split()))
tree2 = list(map(int, input("Enter warehouse2: ").split()))

root1 = build_tree(tree1)
root2 = build_tree(tree2)

print("YES" if are_mirror(root1, root2) else "NO")