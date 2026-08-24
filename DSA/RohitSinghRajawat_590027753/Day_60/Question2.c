#include <stdio.h>

int countSafe(int tree[], int n, int index, int maxValue)
{
    if(index >= n || tree[index] == -1)
        return 0;

    int value = tree[index];
    int count = 0;

    if(value >= maxValue)
    {
        count = 1;
        maxValue = value;
    }

    count += countSafe(tree, n, 2 * index + 1, maxValue);
    count += countSafe(tree, n, 2 * index + 2, maxValue);

    return count;
}

int main()
{
    int tree[] = {3, 1, 4, 3, -1, 1, 5};
    int n = 7;

    printf("%d\n", countSafe(tree, n, 0, -1000000));

    return 0;
}