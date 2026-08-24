#include <stdio.h>

int isMirror(int a[], int n, int b[], int m)
{
    if(n != m)
        return 0;

    for(int i = 0; i < n; i++)
    {
        if(a[i] != b[n - 1 - i])
            return 0;
    }

    return 1;
}