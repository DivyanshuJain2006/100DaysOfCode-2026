//Write an efficient function that finds the ID of the Lowest Common Ancestor of two given employee IDs in a binary tree hierarchy 
//(given in level-order, with -1 for missing nodes), returning -1 if either employee does not exist in the tree.
//Input: tree = [3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4], a = 5, b = 1. Output: 3.
#include <stdio.h>
#include <stdlib.h>

int lowestCommonAncestor(int tree[], int n, int a, int b) {
    if (n == 0 || tree[0] == -1)
        return -1;

    int *parent = malloc(n * sizeof(int));
    if (!parent)
        return -1;

    for (int i = 0; i < n; i++)
        parent[i] = -1;

    for (int i = 0; i < n; i++) {
        if (tree[i] == -1)
            continue;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && tree[left] != -1)
            parent[left] = i;

        if (right < n && tree[right] != -1)
            parent[right] = i;
    }

    int ia = -1, ib = -1;
    for (int i = 0; i < n; i++) {
        if (tree[i] == a)
            ia = i;
        if (tree[i] == b)
            ib = i;
    }

    if (ia == -1 || ib == -1) {
        free(parent);
        return -1;
    }

    char *seen = calloc(n, sizeof(char));
    if (!seen) {
        free(parent);
        return -1;
    }

    int cur = ia;
    while (cur != -1) {
        seen[cur] = 1;
        cur = parent[cur];
    }

    cur = ib;
    while (cur != -1) {
        if (seen[cur]) {
            int result = tree[cur];
            free(seen);
            free(parent);
            return result;
        }
        cur = parent[cur];
    }
    free(seen);
    free(parent);
    return -1;
}

int main(void) {
    int tree[] = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};
    int n = sizeof(tree) / sizeof(tree[0]);
    printf("%d\n", lowestCommonAncestor(tree, n, 5, 1));
    return 0;
}