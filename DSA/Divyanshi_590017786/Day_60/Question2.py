def count_safe_campsites(tree):
    n = len(tree)

    def dfs(index, max_value):
        if index >= n or tree[index] == -1:
            return 0

        value = tree[index]

        if value >= max_value:
            count = 1
        else:
            count = 0

        new_max = max(max_value, value)

        left = 2 * index + 1
        right = 2 * index + 2

        count += dfs(left, new_max)
        count += dfs(right, new_max)

        return count

    if n == 0 or tree[0] == -1:
        return 0

    return dfs(0, tree[0])


# Example
tree = [3, 1, 4, 3, -1, 1, 5]

print(count_safe_campsites(tree))