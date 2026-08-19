#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int main() {
    int n;
    scanf("%d", &n);

    int m = n * (n - 1) / 2;
    int *b = (int *)malloc(m * sizeof(int));

    for (int i = 0; i < m; i++)
        scanf("%d", &b[i]);

    qsort(b, m, sizeof(int), compare);

    int idx = 0;

    for (int i = 0; i < n - 1; i++) {
        printf("%d ", b[idx]);
        idx += (n - 1 - i);
    }

    printf("1000000000\n");

    free(b);
    return 0;
}