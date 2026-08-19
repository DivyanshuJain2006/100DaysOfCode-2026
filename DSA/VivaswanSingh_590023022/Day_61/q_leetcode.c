int findJudge(int n, int** trust, int trustSize, int* trustColSize)
{
    int trustedBy[1001] = {0};
    int trusts[1001] = {0};

    for (int i = 0; i < trustSize; i++)
    {
        int a = trust[i][0];
        int b = trust[i][1];

        trusts[a]++;
        trustedBy[b]++;
    }

    for (int i = 1; i <= n; i++)
    {
        if (trusts[i] == 0 && trustedBy[i] == n - 1)
            return i;
    }

    return -1;
}