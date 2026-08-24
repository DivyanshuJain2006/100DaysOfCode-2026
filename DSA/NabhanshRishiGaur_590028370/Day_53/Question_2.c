#include <stdio.h>
#include <string.h>

void sortString(char str[])
{
    int n = strlen(str);

    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (str[j] > str[j + 1])
            {
                char temp = str[j];
                str[j] = str[j + 1];
                str[j + 1] = temp;
            }
        }
    }
}

int main()
{
    char log[10001];
    char pattern[10001];

    scanf("%s", log);
    scanf("%s", pattern);

    int n = strlen(log);
    int m = strlen(pattern);

    if (m > n)
    {
        printf("[]\n");
        return 0;
    }

    char sortedPattern[10001];

    strcpy(sortedPattern, pattern);
    sortString(sortedPattern);

    int result[10001];
    int resultCount = 0;

    for (int i = 0; i <= n - m; i++)
    {
        char substring[10001];
        strncpy(substring, log + i, m);
        substring[m] = '\0';
        sortString(substring);
        if (strcmp(substring, sortedPattern) == 0)
        {
            result[resultCount++] = i;
        }
    }

    printf("[");

    for (int i = 0; i < resultCount; i++)
    {
        printf("%d", result[i]);

        if (i < resultCount - 1)
        {
            printf(", ");
        }
    }

    printf("]\n");

    return 0;
}
