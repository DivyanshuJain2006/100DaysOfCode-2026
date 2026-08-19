#include <stdio.h>

int minGroups(int n, int mentor[]) {
    int maxDepth = 0;

    for (int i = 0; i < n; i++) {
        int depth = 1;
        int current = i + 1;

        while (mentor[current - 1] != -1) {
            depth++;
            current = mentor[current - 1];
        }

        if (depth > maxDepth) {
            maxDepth = depth;
        }
    }

    return maxDepth;
}

int main() {
    int n;
    scanf("%d", &n);

    int mentor[n];

    for (int i = 0; i < n; i++) {
        scanf("%d", &mentor[i]);
    }

    printf("%d", minGroups(n, mentor));

    return 0;
}
