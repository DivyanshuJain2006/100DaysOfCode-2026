#include <stdio.h>
int main() {
    int t;
    scanf("%d", &t);
    while (t--) {
        int n;
        scanf("%d", &n);
        int tree[n];
        for (int i = 0; i < n; i++)
            scanf("%d", &tree[i]);
        int a, b;
        scanf("%d %d", &a, &b);
        int posA = -1;
        int posB = -1;
        for (int i = 0; i < n; i++) {
            if (tree[i] == a)
                posA = i;
            if (tree[i] == b)
                posB = i;
        }
        if (posA == -1 || posB == -1) {
            printf("-1\n");
            continue;
        }
        while (posA != posB) {
            if (posA > posB)
                posA = (posA - 1) / 2;
            else
                posB = (posB - 1) / 2;
        }
        printf("%d\n", tree[posA]);
    }
    return 0;
}