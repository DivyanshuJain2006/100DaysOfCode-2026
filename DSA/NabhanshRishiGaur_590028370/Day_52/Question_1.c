#include <stdbool.h>
#include <string.h>

bool areOccurrencesEqual(char * s) {
    int freq[26] = {0};
    
    for (int i = 0; s[i] != '\0'; i++) {
        freq[s[i] - 'a']++;
    }
  
    int target = 0;
    for (int i = 0; i < 26; i++) {
        if (freq[i] > 0) {
            target = freq[i];
            break;
        }
    }
  
    for (int i = 0; i < 26; i++) {
        if (freq[i] > 0 && freq[i] != target) {
            return false;
        }
    }
    
    return true;
}
