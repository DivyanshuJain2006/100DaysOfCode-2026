def areMirrors(tree1, tree2):
    if len(tree1) != len(tree2):
        return "NO"

    for i in range(len(tree1)):
        if tree1[i] != tree2[len(tree2) - 1 - i]:
            return "NO"

    return "YES"


print(areMirrors([1, 2, 3], [1, 3, 2]))