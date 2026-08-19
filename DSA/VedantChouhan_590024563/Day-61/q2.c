#include <stdio.h>

int main() {

    int n;

    printf("Enter number of students: ");
    scanf("%d", &n);

    int mentor[n];

    printf("Enter mentor array: ");

    for (int i = 0; i < n; i++) {
        scanf("%d", &mentor[i]);
    }

    int maxGroups = 0;

    for (int i = 0; i < n; i++) {

        int current = i;
        int depth = 1;

        while (mentor[current] != -1) {

            current = mentor[current] - 1;
            depth++;
        }

        if (depth > maxGroups) {
            maxGroups = depth;
        }
    }

    printf("Minimum number of groups: %d\n", maxGroups);

    return 0;
}