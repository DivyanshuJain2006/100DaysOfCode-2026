#include <stdio.h>

#define MAX 1000

typedef struct {
    long long rob;
    long long notRob;
} Result;

Result solve(int tree[], int n, int index) {

    Result result;

    // No house
    if (index >= n || tree[index] == -1) {
        result.rob = 0;
        result.notRob = 0;
        return result;
    }

    int left = 2 * index + 1;
    int right = 2 * index + 2;

    Result leftResult = solve(tree, n, left);
    Result rightResult = solve(tree, n, right);

    // Rob current house
    // Therefore, children cannot be robbed
    result.rob = tree[index]
               + leftResult.notRob
               + rightResult.notRob;

    // Do not rob current house
    // We can choose whether to rob each child
    long long leftBest =
        leftResult.rob > leftResult.notRob
        ? leftResult.rob
        : leftResult.notRob;

    long long rightBest =
        rightResult.rob > rightResult.notRob
        ? rightResult.rob
        : rightResult.notRob;

    result.notRob = leftBest + rightBest;

    return result;
}

long long rob(int tree[], int n) {

    if (n == 0 || tree[0] == -1)
        return 0;

    Result root = solve(tree, n, 0);

    return root.rob > root.notRob
           ? root.rob
           : root.notRob;
}

int main() {

    int n;

    printf("Enter number of positions: ");
    scanf("%d", &n);

    int tree[MAX];

    printf("Enter tree values (-1 for no house): ");

    for (int i = 0; i < n; i++) {
        scanf("%d", &tree[i]);
    }

    printf("Maximum money: %lld\n", rob(tree, n));

    return 0;
}