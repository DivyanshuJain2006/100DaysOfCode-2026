#include <stdio.h>

int countBits(int mask) {
    int count = 0;

    while (mask) {
        count += mask & 1;
        mask >>= 1;
    }

    return count;
}

int countPasscodes(int tree[], int n) {
    int count = 0;

    // Stack for DFS
    int stackIndex[100000];
    int stackMask[100000];

    int top = 0;

    // Start from root
    if (n == 0 || tree[0] == -1)
        return 0;

    stackIndex[top] = 0;

    // Toggle root digit
    stackMask[top] = (1 << tree[0]);

    top++;

    while (top > 0) {
        top--;

        int index = stackIndex[top];
        int mask = stackMask[top];

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        int leftExists = (left < n && tree[left] != -1);
        int rightExists = (right < n && tree[right] != -1);

        // Leaf node
        if (!leftExists && !rightExists) {
            if (countBits(mask) <= 1)
                count++;

            continue;
        }

        // Left child
        if (leftExists) {
            stackIndex[top] = left;
            stackMask[top] = mask ^ (1 << tree[left]);
            top++;
        }

        // Right child
        if (rightExists) {
            stackIndex[top] = right;
            stackMask[top] = mask ^ (1 << tree[right]);
            top++;
        }
    }

    return count;
}

int main() {
    int t;

    printf("Enter number of test cases: ");
    scanf("%d", &t);

    while (t--) {
        int n;

        printf("Enter n: ");
        scanf("%d", &n);

        int tree[n];

        printf("Enter tree elements: ");
        for (int i = 0; i < n; i++) {
            scanf("%d", &tree[i]);
        }

        int answer = countPasscodes(tree, n);

        printf("%d\n", answer);
    }

    return 0;
}