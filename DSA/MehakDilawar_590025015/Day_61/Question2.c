//Write an efficient function that returns the minimum number of groups needed so that no group contains both a student 
//and any of their mentors, given a mentor hierarchy array.
//Input: n = 5, mentor = [-1, 1, 2, 1, -1]. Output: 3.
#include <stdio.h>
int getDepth(int student, int mentor[], int depth[]) {
    if (depth[student] != 0)
        return depth[student];
    if (mentor[student - 1] == -1)
        depth[student] = 1;
    else
        depth[student] = getDepth(mentor[student - 1], mentor, depth) + 1;
    return depth[student];
}

int minGroups(int n, int mentor[]) {
    int depth[n + 1];
    int maxDepth = 0;
    for (int i = 0; i <= n; i++)
        depth[i] = 0;
    for (int i = 1; i <= n; i++) {
        int d = getDepth(i, mentor, depth);
        if (d > maxDepth)
            maxDepth = d;
    }
    return maxDepth;
}

int main() {
    int n;
    printf("Enter number of students: ");
    scanf("%d", &n);
    int mentor[n];
    printf("Enter mentor array (%d values):\n", n);
    for (int i = 0; i < n; i++)
        scanf("%d", &mentor[i]);
    printf("Minimum number of groups: %d\n", minGroups(n, mentor));
return 0;
}