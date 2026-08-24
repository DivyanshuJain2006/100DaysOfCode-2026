# The Secret Passcodes

def count_palindrome_paths(tree):
    if not tree or tree[0] == -1:
        return 0

    n = len(tree)
    count = 0

    def dfs(index, mask):
        nonlocal count

        if index >= n or tree[index] == -1:
            return

        mask ^= 1 << tree[index]

        left = 2 * index + 1
        right = 2 * index + 2

        if (left >= n or tree[left] == -1) and (right >= n or tree[right] == -1):
            if mask & (mask - 1) == 0:
                count += 1
            return

        dfs(left, mask)
        dfs(right, mask)

    dfs(0, 0)
    return count


tree = list(map(int, input("Enter tree elemnts : ").split()))

print(count_palindrome_paths(tree))