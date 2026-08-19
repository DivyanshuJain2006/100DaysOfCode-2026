#include <stdio.h>

void insertAtBottom(int stack[], int *top, int x) {
    int temp[100];
    int tempTop = -1;

    // Move all elements to temporary stack
    while (*top >= 0) {
        temp[++tempTop] = stack[(*top)--];
    }

    // Insert x at the bottom
    stack[++(*top)] = x;

    // Put the elements back
    while (tempTop >= 0) {
        stack[++(*top)] = temp[tempTop--];
    }
}

int main() {
    int stack[100] = {1, 2, 3, 4};
    int top = 3;
    int x = 5;

    insertAtBottom(stack, &top, x);

    printf("Updated stack: ");

    for (int i = 0; i <= top; i++) {
        printf("%d ", stack[i]);
    }

    return 0;
}