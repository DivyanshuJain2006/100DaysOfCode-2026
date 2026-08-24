#include <stdio.h>
#include <string.h>

#define MAX_USERS 100000
#define MAX_LEN 40

int main()
{
    int n;
    scanf("%d", &n);

    char names[MAX_USERS][MAX_LEN];
    int count[MAX_USERS] = {0};

    for (int i = 0; i < n; i++)
    {
        char username[MAX_LEN];
        scanf("%s", username);

        int found = -1;

        for (int j = 0; j < i; j++)
        {
            if (strcmp(names[j], username) == 0)
            {
                found = j;
                break;
            }
        }
      
        if (found == -1)
        {
            strcpy(names[i], username);
            count[i] = 1;

            printf("OK\n");
        }
        else
        {
            char newUsername[MAX_LEN];

            while (1)
            {
                sprintf(newUsername, "%s%d",
                        username, count[found]);

                int exists = 0;
                for (int j = 0; j < i; j++)
                {
                    if (strcmp(names[j], newUsername) == 0)
                    {
                        exists = 1;
                        break;
                    }
                }

                if (!exists)
                {
                    strcpy(names[i], newUsername);

                    printf("%s\n", newUsername);

                    count[found]++;
                    break;
                }

                count[found]++;
            }
        }
    }

    return 0;
}
