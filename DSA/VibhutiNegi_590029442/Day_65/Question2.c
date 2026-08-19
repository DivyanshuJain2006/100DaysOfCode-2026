#include <stdio.h>
#include <math.h>
int main()
{
    int T;
    scanf("%d", &T);
    while (T--)
    {
        int n;
        scanf("%d", &n);
        int tree[1001];
        for (int i = 1; i <= n; i++)
        {
            scanf("%d", &tree[i]);
        }
        double target;
        scanf("%lf", &target);
        int i = 1;
        int answer = tree[1];
        double min = fabs(tree[1] - target);
        while (i <= n && tree[i] != -1)
        {
            double difference = fabs(tree[i] - target);
            if (difference < min)
            {
                min = difference;
                answer = tree[i];
            }
            else if (difference == min && tree[i] < answer)
            {
                answer = tree[i];
            }
            if (target < tree[i])
            {
                i = 2 * i;   
            }
            else
            {
                i = 2 * i + 1;  
            }
        }
        printf("%d\n", answer);
    }
    return 0;
}