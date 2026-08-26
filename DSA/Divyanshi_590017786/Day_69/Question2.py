class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def split_bst(root, k):
    if root is None:
        return None, None

    if root.value < k:
        left_tree, right_tree = split_bst(root.right, k)
        root.right = left_tree
        return root, right_tree

    else:
        left_tree, right_tree = split_bst(root.left, k)
        root.left = right_tree
        return left_tree, root


def preorder(root, result):
    if root is None:
        return

    result.append(str(root.value))
    preorder(root.left, result)
    preorder(root.right, result)


# Build BST
root = Node(10)
root.left = Node(5)
root.right = Node(15)

root.left.left = Node(2)
root.left.right = Node(7)

root.right.left = Node(12)
root.right.right = Node(20)

K = 10

left_tree, right_tree = split_bst(root, K)

left_result = []
right_result = []

preorder(left_tree, left_result)
preorder(right_tree, right_result)

left_output = " ".join(left_result) if left_result else "EMPTY"
right_output = " ".join(right_result) if right_result else "EMPTY"

print(left_output)
print(right_output)