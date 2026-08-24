#include <stdio.h>
int findGroups(int n, int mentor[]) {
    int maxGroups = 1;
    for (int i = 0; i < n; i++) {
        int current = i + 1;
        int groups = 1;
        while (mentor[current - 1] != -1) {
            current = mentor[current - 1];
            groups++;
        }
        if (groups > maxGroups)
            maxGroups = groups;
    }
    return maxGroups;
}
int main() {
    int n;
    scanf("%d", &n);
    int mentor[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", &mentor[i]);
    }
    printf("%d", findGroups(n, mentor));
    return 0;
}