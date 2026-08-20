#include <stdio.h>

#define MAX 100

int main() {
    int stack1[MAX], stack2[MAX], temp[MAX];
    int top1 = -1, top2 = -1, topTemp = -1;
    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter stack elements: ");

    for (int i = 0; i < n; i++) {
        scanf("%d", &stack1[++top1]);
    }

    // Step 1: Move stack1 to temporary stack
    while (top1 >= 0) {
        temp[++topTemp] = stack1[top1--];
    }

    // Step 2: Move temporary stack to stack2
    while (topTemp >= 0) {
        stack2[++top2] = temp[topTemp--];
    }

    // Print copied stack
    printf("Copied stack: ");

    for (int i = 0; i <= top2; i++) {
        printf("%d ", stack2[i]);
    }

    printf("\n");

    return 0;
}