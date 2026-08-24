#include <stdio.h>

int isMirror(int tree1[], int n1, int tree2[], int n2, int i, int j) {

    if ((i >= n1 || tree1[i] == -1) &&
        (j >= n2 || tree2[j] == -1)) {
        return 1;
    }
    if (i >= n1 || tree1[i] == -1 ||
        j >= n2 || tree2[j] == -1) {
        return 0;
    }
    if (tree1[i] != tree2[j]) {
        return 0;
    }


    return isMirror(tree1, n1, tree2, n2,
                    2 * i + 1, 2 * j + 2)
        &&
           isMirror(tree1, n1, tree2, n2,
                    2 * i + 2, 2 * j + 1);
}

int main() {

    int t;

    scanf("%d", &t);

    while (t--) {

        int n1;
        scanf("%d", &n1);

        int tree1[n1];

        for (int i = 0; i < n1; i++) {
            scanf("%d", &tree1[i]);
        }

        int n2;
        scanf("%d", &n2);

        int tree2[n2];

        for (int i = 0; i < n2; i++) {
            scanf("%d", &tree2[i]);
        }

        if (isMirror(tree1, n1, tree2, n2, 0, 0)) {
            printf("YES\n");
        }
        else {
            printf("NO\n");
        }
    }

    return 0;
}