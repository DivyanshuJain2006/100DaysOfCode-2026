def rob_tree(tree):
    n = len(tree)

    def dfs(index):
        if index >= n or tree[index] == -1:
            return (0, 0)

        left_rob, left_skip = dfs(2 * index + 1)
        right_rob, right_skip = dfs(2 * index + 2)

        # If we rob current house, we cannot rob its children
        rob = tree[index] + left_skip + right_skip

        # If we skip current house, choose the better option
        # from each child
        skip = max(left_rob, left_skip) + max(right_rob, right_skip)

        return (rob, skip)

    rob, skip = dfs(0)

    return max(rob, skip)


# Example
tree = [3, 2, 3, -1, 3, -1, 1]

print(rob_tree(tree))