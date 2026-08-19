#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int mentor[n];

    for (int i = 0; i < n; i++) {
        scanf("%d", &mentor[i]);
    }

    int maxGroups = 0;

    for (int i = 0; i < n; i++) {
        int current = i;
        int count = 1;

        while (mentor[current] != -1) {
            current = mentor[current] - 1;
            count++;
        }

        if (count > maxGroups) {
            maxGroups = count;
        }
    }

    printf("%d\n", maxGroups);

    return 0;
}