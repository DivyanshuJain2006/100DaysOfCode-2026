class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def largest_bst(root):
    max_size = [0]

    def dfs(node):
        if node is None:
            # min value, max value, size, is_bst
            return (float("inf"), float("-inf"), 0, True)

        left_min, left_max, left_size, left_bst = dfs(node.left)
        right_min, right_max, right_size, right_bst = dfs(node.right)

        # Check whether current subtree is a BST
        if left_bst and right_bst and left_max < node.value < right_min:
            size = left_size + right_size + 1
            max_size[0] = max(max_size[0], size)

            return (
                min(left_min, node.value),
                max(right_max, node.value),
                size,
                True
            )

        # Not a BST
        return (0, 0, 0, False)

    dfs(root)
    return max_size[0]


# Build tree:
# [10, 5, 15, 1, 8, -1, 7]

root = Node(10)
root.left = Node(5)
root.right = Node(15)

root.left.left = Node(1)
root.left.right = Node(8)

root.right.right = Node(7)

print(largest_bst(root))