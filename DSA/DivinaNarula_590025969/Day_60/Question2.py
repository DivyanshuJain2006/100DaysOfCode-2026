class TreeNode:
    def __init__(self, val=0):
        self.val = val
        self.left = None
        self.right = None


def buildTree(values):
    if not values or values[0] == -1:
        return None

    nodes = [
        TreeNode(value) if value != -1 else None
        for value in values
    ]

    for i in range(len(values)):
        if nodes[i] is not None:
            left = 2 * i + 1
            right = 2 * i + 2

            if left < len(values):
                nodes[i].left = nodes[left]

            if right < len(values):
                nodes[i].right = nodes[right]

    return nodes[0]


def countSafeNodes(root):
    def dfs(node, maximum):
        if node is None:
            return 0

        if node.val >= maximum:
            count = 1
            maximum = node.val
        else:
            count = 0

        return count + dfs(node.left, maximum) + dfs(node.right, maximum)

    return dfs(root, float('-inf'))


n = int(input("Enter number of elements: "))
values = list(map(int, input("Enter tree elements: ").split()))

root = buildTree(values)

print("Number of safe campsites:", countSafeNodes(root))