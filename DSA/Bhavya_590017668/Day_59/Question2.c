#include <stdio.h>

int countPaths(int *a, int n, int i, int mask) {
    if (i >= n || a[i] == -1)
        return 0;

    mask ^= (1 << a[i]);

    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if ((left >= n || a[left] == -1) &&
        (right >= n || a[right] == -1))
        return (mask == 0 || (mask & (mask - 1)) == 0);

    return countPaths(a, n, left, mask) +
           countPaths(a, n, right, mask);
}

int main() {
    int n;
    scanf("%d", &n);

    int a[n];
    for (int i = 0; i < n; i++)
        scanf("%d", &a[i]);

    printf("%d", countPaths(a, n, 0, 0));

    return 0;
}