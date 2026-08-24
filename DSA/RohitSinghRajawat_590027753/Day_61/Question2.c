int maxDepth(int n, int mentor[])
{
    int max = 1;

    for(int i = 0; i < n; i++)
    {
        int depth = 1;
        int x = i;

        while(mentor[x] != -1)
        {
            depth++;
            x = mentor[x] - 1;
        }

        if(depth > max)
            max = depth;
    }

    return max;
}