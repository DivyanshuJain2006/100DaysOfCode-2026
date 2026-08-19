#include <stdio.h>

#define MAX 1000

int findLCA(int tree[], int n, int a, int b) {

    int current = 0;

    while (current < n && tree[current] != -1) {

        int value = tree[current];

        // Both values are smaller
        if (a < value && b < value) {
            current = 2 * current + 1;
        }

        // Both values are larger
        else if (a > value && b > value) {
            current = 2 * current + 2;
        }

        // Values are on different sides,
        // or current node is a or b
        else {
            return value;
        }
    }

    return -1;
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

        int a, b;
        scanf("%d %d", &a, &b);

        int answer = findLCA(tree, n, a, b);

        printf("%d\n", answer);
    }

    return 0;
}