#include <stdbool.h>
#include <string.h>

bool backspaceCompare(char* s, char* t) {
    int i = strlen(s) - 1;
    int j = strlen(t) - 1;

    int skipS = 0;
    int skipT = 0;

    while (i >= 0 || j >= 0) {

        // Find the next valid character in s
        while (i >= 0) {
            if (s[i] == '#') {
                skipS++;
                i--;
            }
            else if (skipS > 0) {
                skipS--;
                i--;
            }
            else {
                break;
            }
        }

        // Find the next valid character in t
        while (j >= 0) {
            if (t[j] == '#') {
                skipT++;
                j--;
            }
            else if (skipT > 0) {
                skipT--;
                j--;
            }
            else {
                break;
            }
        }

        // Compare the valid characters
        if (i >= 0 && j >= 0 && s[i] != t[j])
            return false;

        // One string has a character while the other doesn't
        if ((i >= 0) != (j >= 0))
            return false;

        i--;
        j--;
    }

    return true;
}