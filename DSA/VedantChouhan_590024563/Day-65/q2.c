#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define MAX 1000

int closestValue(int tree[], int n, double target) {
    int index = 0;
    int answer = -1;
    double bestDiff = 1e18;

    while (index < n && tree[index] != -1) {

        int value = tree[index];
        double diff = fabs(value - target);

        // Better distance
        // Or same distance but smaller value
        if (diff < bestDiff ||
            (diff == bestDiff && value < answer)) {

            bestDiff = diff;
            answer = value;
        }

        if (target < value) {
            index = 2 * index + 1;
        }
        else if (target > value) {
            index = 2 * index + 2;
        }
        else {
            return value;
        }
    }

    return answer;
}

int main() {

    int T;
    scanf("%d", &T);

    while (T--) {

        int n;
        scanf("%d", &n);

        int tree[MAX];

        for (int i = 0; i < n; i++) {
            scanf("%d", &tree[i]);
        }

        double target;
        scanf("%lf", &target);

        printf("%d\n", closestValue(tree, n, target));
    }

    return 0;
}