#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int findContentChildren(int* g, int gSize, int* s, int sSize) {
    
    // Sort greed factors and cookie sizes
    qsort(g, gSize, sizeof(int), compare);
    qsort(s, sSize, sizeof(int), compare);

    int child = 0;
    int cookie = 0;
    int count = 0;

    while (child < gSize && cookie < sSize) {
        
        // Cookie can satisfy this child
        if (s[cookie] >= g[child]) {
            count++;
            child++;
        }

        // Move to the next cookie
        cookie++;
    }

    return count;
}