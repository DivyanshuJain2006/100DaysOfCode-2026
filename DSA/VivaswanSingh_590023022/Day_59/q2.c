#include <stdio.h>

int dfs(int tree[], int n, int index, int mask)
{
    if (index >= n || tree[index] == -1)
        return 0;

    mask ^= (1 << tree[index]);

    int left = 2 * index + 1;
    int right = 2 * index + 2;

    if ((left >= n || tree[left] == -1) &&
        (right >= n || tree[right] == -1))
    {
        if ((mask & (mask - 1)) == 0)
            return 1;

        return 0;
    }

    return dfs(tree, n, left, mask) +
           dfs(tree, n, right, mask);
}

int countPalindromicPaths(int tree[], int n)
{
    return dfs(tree, n, 0, 0);
}

int main()
{
    int tree[] = {2, 3, 1, 3, 1, -1, 1};
    int n = sizeof(tree) / sizeof(tree[0]);

    printf("%d\n", countPalindromicPaths(tree, n));

    return 0;
}