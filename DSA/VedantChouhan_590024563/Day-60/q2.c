#include <stdio.h>
#include <stdlib.h>

#define MAX 1000

int countSafe(int tree[], int n, int index, int maxValue) {

    if (index >= n || tree[index] == -1)
        return 0;

    int current = tree[index];

    int count = 0;

    // Current node is safe
    if (current >= maxValue) {
        count = 1;
    }

    // Update maximum altitude on this path
    if (current > maxValue) {
        maxValue = current;
    }

    int left = 2 * index + 1;
    int right = 2 * index + 2;

    count += countSafe(tree, n, left, maxValue);
    count += countSafe(tree, n, right, maxValue);

    return count;
}

int main() {

    int t;
    scanf("%d", &t);

    while (t--) {

        int n;
        scanf("%d", &n);

        int tree[MAX];

        for (int i = 0; i < n; i++) {
            scanf("%d", &tree[i]);
        }

        if (tree[0] == -1) {
            printf("0\n");
            continue;
        }

        int answer = countSafe(tree, n, 0, -1000000000);

        printf("%d\n", answer);
    }

    return 0;
}