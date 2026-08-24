#include <stdio.h>

int max(int a, int b)
{
    return a > b ? a : b;
}

int findDepth(int person, int mentor[])
{
    if (mentor[person] == -1)
        return 1;

    return 1 + findDepth(mentor[person], mentor);
}

int main()
{
    int n = 5;
    int mentor[] = {-1, 1, 2, 1, -1};

    int answer = 0;

    for (int i = 0; i < n; i++)
    {
        int depth = findDepth(i, mentor);

        answer = max(answer, depth);
    }

    printf("Minimum Groups: %d\n", answer);

    return 0;
}