#include <stdio.h>

int isMirror(int a[], int n1, int i,
             int b[], int n2, int j) {

    if ((i >= n1 || a[i] == -1) &&
        (j >= n2 || b[j] == -1))
        return 1;

    if (i >= n1 || a[i] == -1 ||
        j >= n2 || b[j] == -1)
        return 0;

    if (a[i] != b[j])
        return 0;

    return isMirror(a, n1, 2 * i + 1,
                    b, n2, 2 * j + 2)
        &&
           isMirror(a, n1, 2 * i + 2,
                    b, n2, 2 * j + 1);
}

int main() {
    int t;

    printf("Enter number of test cases: ");
    scanf("%d", &t);

    while (t--) {

        int n1, n2;

        printf("\nEnter number of nodes in Warehouse 1: ");
        scanf("%d", &n1);

        int warehouse1[n1];

        printf("Enter Warehouse 1 elements: ");
        for (int i = 0; i < n1; i++) {
            scanf("%d", &warehouse1[i]);
        }

        printf("Enter number of nodes in Warehouse 2: ");
        scanf("%d", &n2);

        int warehouse2[n2];

        printf("Enter Warehouse 2 elements: ");
        for (int i = 0; i < n2; i++) {
            scanf("%d", &warehouse2[i]);
        }

        if (n1 != n2) {
            printf("NO\n");
        }
        else if (isMirror(warehouse1, n1, 0,
                          warehouse2, n2, 0)) {
            printf("YES\n");
        }
        else {
            printf("NO\n");
        }
    }

    return 0;
}