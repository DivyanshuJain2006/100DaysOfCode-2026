#include <stdio.h>

int main() {

    int n, trustSize;

    printf("Enter number of people: ");
    scanf("%d", &n);

    printf("Enter number of trust relationships: ");
    scanf("%d", &trustSize);

    int trust[trustSize][2];

    printf("Enter trust relationships:\n");

    for (int i = 0; i < trustSize; i++) {
        scanf("%d %d", &trust[i][0], &trust[i][1]);
    }

    int score[n + 1];

    for (int i = 0; i <= n; i++) {
        score[i] = 0;
    }

    for (int i = 0; i < trustSize; i++) {

        int a = trust[i][0];
        int b = trust[i][1];

        // a trusts someone, so a cannot be judge
        score[a]--;

        // b is trusted by someone
        score[b]++;
    }

    int judge = -1;

    for (int i = 1; i <= n; i++) {

        if (score[i] == n - 1) {
            judge = i;
            break;
        }
    }

    printf("Town Judge: %d\n", judge);

    return 0;
}