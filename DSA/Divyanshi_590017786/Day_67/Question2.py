class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def build_bst(arr, left, right):
    if left > right:
        return None

    # Left-middle for even length
    mid = (left + right) // 2

    root = Node(arr[mid])
    root.left = build_bst(arr, left, mid - 1)
    root.right = build_bst(arr, mid + 1, right)

    return root


def get_height_and_count(root, count):
    if root is None:
        return 0

    left_height = get_height_and_count(root.left, count)
    right_height = get_height_and_count(root.right, count)

    balance = left_height - right_height

    if balance == -1:
        count[0] += 1
    elif balance == 0:
        count[1] += 1
    elif balance == 1:
        count[2] += 1

    return 1 + max(left_height, right_height)


def balance_spectrum(arr):
    root = build_bst(arr, 0, len(arr) - 1)

    # count[0] = BF -1
    # count[1] = BF  0
    # count[2] = BF +1
    count = [0, 0, 0]

    get_height_and_count(root, count)

    return count


arr = [1, 2, 3, 4, 5, 6, 7]

print(balance_spectrum(arr))