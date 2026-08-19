#include <stdlib.h>
#include <string.h>

char* removeDuplicates(char* s) {
    int n = strlen(s);

    char* stack = (char*)malloc((n + 1) * sizeof(char));
    int top = -1;

    for (int i = 0; i < n; i++) {

        if (top >= 0 && stack[top] == s[i]) {
            // Same adjacent character → remove it
            top--;
        } 
        else {
            // Different character → push it
            stack[++top] = s[i];
        }
    }

    stack[top + 1] = '\0';

    return stack;
}