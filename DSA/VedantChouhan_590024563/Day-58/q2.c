#include <stdio.h>

#define MAX 1000

int findPath(int tree[], int n, int target, int path[], int *pathSize) {

    *pathSize = 0;

    for (int i = 0; i < n; i++) {

        if (tree[i] == target) {

            int current = i;

            while (1) {

                path[(*pathSize)++] = current;

                if (current == 0)
                    break;

                current = (current - 1) / 2;
            }

            // Reverse path so it goes root -> target
            for (int j = 0; j < *pathSize / 2; j++) {
                int temp = path[j];
                path[j] = path[*pathSize - 1 - j];
                path[*pathSize - 1 - j] = temp;
            }

            return 1;
        }
    }

    return 0;
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

        int pathA[MAX];
        int pathB[MAX];

        int sizeA, sizeB;

        int foundA = findPath(tree, n, a, pathA, &sizeA);
        int foundB = findPath(tree, n, b, pathB, &sizeB);

        if (!foundA || !foundB) {
            printf("-1\n");
            continue;
        }

        int lcaIndex = -1;

        int minSize = sizeA < sizeB ? sizeA : sizeB;

        for (int i = 0; i < minSize; i++) {

            if (pathA[i] == pathB[i]) {
                lcaIndex = pathA[i];
            }
            else {
                break;
            }
        }

        printf("%d\n", tree[lcaIndex]);
    }

    return 0;
}