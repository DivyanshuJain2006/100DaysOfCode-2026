#include <stdio.h>

int isMirror(int a[], int b[], int n)
{
    for (int i = 0; i < n; i++)
    {
        if (a[i] != b[n - 1 - i])
            return 0;
    }

    return 1;
}

int main()
{
    int warehouse1[] = {1, 2, 3};
    int warehouse2[] = {1, 3, 2};

    int n = 3;

    if (isMirror(warehouse1, warehouse2, n))
        printf("YES\n");
    else
        printf("NO\n");

    return 0;
}