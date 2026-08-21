# The Balance Spectrum

class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def build_bst(arr, left, right):
    if left > right:
        return None

    mid = (left + right) // 2

    node = Node(arr[mid])
    node.left = build_bst(arr, left, mid - 1)
    node.right = build_bst(arr, mid + 1, right)

    return node


def get_height(node):
    if node is None:
        return 0

    return 1 + max(get_height(node.left), get_height(node.right))


def count_balance(node, count):
    if node is None:
        return

    left_height = get_height(node.left)
    right_height = get_height(node.right)

    balance = left_height - right_height

    if balance == -1:
        count[0] += 1
    elif balance == 0:
        count[1] += 1
    elif balance == 1:
        count[2] += 1

    count_balance(node.left, count)
    count_balance(node.right, count)


arr = list(map(int, input("Enter sorted array: ").split()))

root = build_bst(arr, 0, len(arr) - 1)

count = [0, 0, 0]

count_balance(root, count)

print("Output:", count)