#include <stdio.h>

int kthSmallest(int A[], int n, int B[], int m, int k) {
    if (n > m)
        return kthSmallest(B, m, A, n, k);

    int low = (k > m) ? (k - m) : 0;
    int high = (k < n) ? k : n;

    while (low <= high) {
        int cutA = (low + high) / 2;
        int cutB = k - cutA;

        int leftA = (cutA == 0) ? -1000000000 : A[cutA - 1];
        int leftB = (cutB == 0) ? -1000000000 : B[cutB - 1];
        int rightA = (cutA == n) ? 1000000000 : A[cutA];
        int rightB = (cutB == m) ? 1000000000 : B[cutB];

        if (leftA <= rightB && leftB <= rightA) {
            return (leftA > leftB) ? leftA : leftB;
        }
        else if (leftA > rightB) {
            high = cutA - 1;
        }
        else {
            low = cutA + 1;
        }
    }

    return -1;
}

int main() {
    int n, m, k;

    scanf("%d", &n);
    int A[n];
    for (int i = 0; i < n; i++)
        scanf("%d", &A[i]);

    scanf("%d", &m);
    int B[m];
    for (int i = 0; i < m; i++)
        scanf("%d", &B[i]);

    scanf("%d", &k);

    printf("%d\n", kthSmallest(A, n, B, m, k));

    return 0;
}