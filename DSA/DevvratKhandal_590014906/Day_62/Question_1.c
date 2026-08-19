#include <stdio.h>

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    int trust[m][2];
    int inDegree[n + 1], outDegree[n + 1];

    for (int i = 0; i <= n; i++) {
        inDegree[i] = 0;
        outDegree[i] = 0;
    }

    for (int i = 0; i < m; i++) {
        scanf("%d %d", &trust[i][0], &trust[i][1]);

        outDegree[trust[i][0]]++;
        inDegree[trust[i][1]]++;
    }

    for (int i = 1; i <= n; i++) {
        if (inDegree[i] == n - 1 && outDegree[i] == 0) {
            printf("%d\n", i);
            return 0;
        }
    }

    printf("-1\n");

    return 0;
}