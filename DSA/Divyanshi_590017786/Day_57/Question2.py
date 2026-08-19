class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def build_tree(arr):
    if not arr or arr[0] == -1:
        return None

    root = Node(arr[0])
    queue = [root]
    i = 1

    for node in queue:
        if i < len(arr) and arr[i] != -1:
            node.left = Node(arr[i])
            queue.append(node.left)
        i += 1

        if i < len(arr) and arr[i] != -1:
            node.right = Node(arr[i])
            queue.append(node.right)
        i += 1

    return root


def is_mirror(root1, root2):
    if root1 is None and root2 is None:
        return True

    if root1 is None or root2 is None:
        return False

    return (root1.value == root2.value and
            is_mirror(root1.left, root2.right) and
            is_mirror(root1.right, root2.left))


def twin_warehouses(warehouse1, warehouse2):
    root1 = build_tree(warehouse1)
    root2 = build_tree(warehouse2)

    if is_mirror(root1, root2):
        return "YES"
    return "NO"


# Example
warehouse1 = [1, 2, 3]
warehouse2 = [1, 3, 2]

print(twin_warehouses(warehouse1, warehouse2))