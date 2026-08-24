#include <stdio.h>

#define MAX_SIZE 1000

typedef struct
{
    int i;
    int j;
} Pair;

int isMirror(long long tree1[], int n1,
             long long tree2[], int n2)
{
    Pair queue[2 * MAX_SIZE];

    int front = 0;
    int rear = 0;

    queue[rear].i = 0;
    queue[rear].j = 0;
    rear++;

    while (front < rear)
    {
        int i = queue[front].i;
        int j = queue[front].j;
        front++;

        int missing1 = (i >= n1 || tree1[i] == -1);
        int missing2 = (j >= n2 || tree2[j] == -1);

        if (missing1 && missing2)
        {
            continue;
        }

        if (missing1 || missing2)
        {
            return 0;
        }

        if (tree1[i] != tree2[j])
        {
            return 0;
        }

        queue[rear].i = 2 * i + 1;
        queue[rear].j = 2 * j + 2;
        rear++;
        queue[rear].i = 2 * i + 2;
        queue[rear].j = 2 * j + 1;
        rear++;
    }

    return 1;
}

int main()
{
    int t;

    scanf("%d", &t);

    while (t--)
    {
        int n1, n2;

        scanf("%d", &n1);

        long long tree1[MAX_SIZE];

        for (int i = 0; i < n1; i++)
        {
            scanf("%lld", &tree1[i]);
        }

        scanf("%d", &n2);

        long long tree2[MAX_SIZE];

        for (int i = 0; i < n2; i++)
        {
            scanf("%lld", &tree2[i]);
        }

        if (isMirror(tree1, n1, tree2, n2))
            printf("YES\n");
        else
            printf("NO\n");
    }

    return 0;
}
