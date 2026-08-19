#include <stdlib.h>

int col;

// Comparator for qsort
int compare(const void *a, const void *b) {
    int *row1 = *(int **)a;
    int *row2 = *(int **)b;

    return row2[col] - row1[col];   // Descending order
}

int** sortTheStudents(int** score, int scoreSize, int* scoreColSize, int k, int* returnSize, int** returnColumnSizes) {
    col = k;

    qsort(score, scoreSize, sizeof(int *), compare);

    *returnSize = scoreSize;
    *returnColumnSizes = scoreColSize;

    return score;
}