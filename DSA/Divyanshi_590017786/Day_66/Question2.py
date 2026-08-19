class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def inorder(root, result):
    if root is None:
        return

    inorder(root.left, result)
    result.append(root.value)
    inorder(root.right, result)


def merge_trees(root1, root2):
    values1 = []
    values2 = []

    inorder(root1, values1)
    inorder(root2, values2)

    # Merge two sorted arrays
    i = 0
    j = 0
    result = []

    while i < len(values1) and j < len(values2):
        if values1[i] < values2[j]:
            value = values1[i]
            i += 1
        elif values1[i] > values2[j]:
            value = values2[j]
            j += 1
        else:
            value = values1[i]
            i += 1
            j += 1

        if not result or result[-1] != value:
            result.append(value)

    while i < len(values1):
        if not result or result[-1] != values1[i]:
            result.append(values1[i])
        i += 1

    while j < len(values2):
        if not result or result[-1] != values2[j]:
            result.append(values2[j])
        j += 1

    return result


# Tree 1: [2, 1, 3]
root1 = Node(2)
root1.left = Node(1)
root1.right = Node(3)

# Tree 2: [4, -1, 5]
root2 = Node(4)
root2.right = Node(5)

print(merge_trees(root1, root2))