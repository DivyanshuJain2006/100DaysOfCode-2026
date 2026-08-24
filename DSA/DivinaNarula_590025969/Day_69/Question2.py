# The Great Divide

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def insert(root, val):
    if root is None:
        return TreeNode(val)

    if val < root.val:
        root.left = insert(root.left, val)
    else:
        root.right = insert(root.right, val)

    return root


def split_bst(root, k):
    if root is None:
        return None, None

    if root.val < k:
        small_root, greater_root = split_bst(root.right, k)
        root.right = small_root
        return root, greater_root
    else:
        small_root, greater_root = split_bst(root.left, k)
        root.left = greater_root
        return small_root, root


def preorder(root, result):
    if root is None:
        return

    result.append(str(root.val))
    preorder(root.left, result)
    preorder(root.right, result)


def get_preorder(root):
    result = []
    preorder(root, result)

    if len(result) == 0:
        return "EMPTY"

    return " ".join(result)


values = list(map(int, input("Enter BST values: ").split()))
k = int(input("Enter K: "))

root = None

for value in values:
    root = insert(root, value)

less_than_k, greater_or_equal_k = split_bst(root, k)

print([get_preorder(less_than_k), get_preorder(greater_or_equal_k)])