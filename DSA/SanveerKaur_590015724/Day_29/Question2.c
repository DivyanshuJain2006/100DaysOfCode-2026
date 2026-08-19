#include <stdio.h>
#include <string.h>

int main() {
    char str[100];
    char stack[100];
    int top = -1;

    printf("Enter a string: ");
    scanf("%s", str);

    // Push each character into the stack
    for (int i = 0; i < strlen(str); i++) {
        stack[++top] = str[i];
    }

    // Pop characters to get the reverse
    printf("Reversed string: ");

    while (top >= 0) {
        printf("%c", stack[top--]);
    }

    printf("\n");

    return 0;
}