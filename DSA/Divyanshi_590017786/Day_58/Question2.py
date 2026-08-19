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


def find_node(root, value):
    if root is None:
        return False

    if root.value == value:
        return True

    return find_node(root.left, value) or find_node(root.right, value)


def find_lca(root, a, b):
    if root is None:
        return None

    if root.value == a or root.value == b:
        return root

    left = find_lca(root.left, a, b)
    right = find_lca(root.right, a, b)

    if left and right:
        return root

    if left:
        return left

    return right


def dispute_resolution(tree, a, b):
    root = build_tree(tree)

    # Check whether both employees exist
    if not find_node(root, a) or not find_node(root, b):
        return -1

    lca = find_lca(root, a, b)

    if lca:
        return lca.value

    return -1


# Example
tree = [3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4]
a = 5
b = 1

print("LCA:", dispute_resolution(tree, a, b))