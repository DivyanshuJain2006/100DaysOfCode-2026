#include <stdio.h>

#define MAX 100000

long long countValidPaths(int tree[], int n, int index, int mask) {

    if (index >= n || tree[index] == -1)
        return 0;

    // Toggle the parity of this digit
    mask ^= (1 << tree[index]);

    int left = 2 * index + 1;
    int right = 2 * index + 2;

    // Check if current node is a leaf
    if ((left >= n || tree[left] == -1) &&
        (right >= n || tree[right] == -1)) {

        // At most one digit can have odd frequency
        if ((mask & (mask - 1)) == 0)
            return 1;

        return 0;
    }

    return countValidPaths(tree, n, left, mask) +
           countValidPaths(tree, n, right, mask);
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

        long long answer = countValidPaths(tree, n, 0, 0);

        printf("%lld\n", answer);
    }

    return 0;
}