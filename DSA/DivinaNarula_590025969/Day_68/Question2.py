# The Franchise Audit

class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def build_tree(values):
    if not values or values[0] == -1:
        return None

    root = TreeNode(values[0])
    queue = [root]
    front = 0
    index = 1

    while front < len(queue) and index < len(values):
        current = queue[front]
        front += 1

        if index < len(values) and values[index] != -1:
            current.left = TreeNode(values[index])
            queue.append(current.left)
        index += 1

        if index < len(values) and values[index] != -1:
            current.right = TreeNode(values[index])
            queue.append(current.right)
        index += 1

    return root


def largest_bst_subtree(root):
    def find_details(node):
        if node is None:
            return True, 0, float("inf"), float("-inf"), 0

        left = find_details(node.left)
        right = find_details(node.right)

        left_is_bst, left_size, left_min, left_max, left_best = left
        right_is_bst, right_size, right_min, right_max, right_best = right

        if (
            left_is_bst
            and right_is_bst
            and left_max < node.value < right_min
        ):
            size = left_size + right_size + 1
            minimum = min(left_min, node.value)
            maximum = max(right_max, node.value)

            return True, size, minimum, maximum, size

        return False, 0, 0, 0, max(left_best, right_best)

    return find_details(root)[4]


while True:
    user_input = input(
        "Enter the tree values separated by spaces using -1 for empty nodes: "
    )

    try:
        cleaned_input = user_input.replace("[", "").replace("]", "").replace(",", " ")
        values = [int(value) for value in cleaned_input.split()]

        if not values:
            raise ValueError

        break
    except ValueError:
        print("Invalid input. Example: 10 5 15 1 8 -1 7")


root = build_tree(values)
answer = largest_bst_subtree(root)

print("Size of the largest BST subtree:", answer)