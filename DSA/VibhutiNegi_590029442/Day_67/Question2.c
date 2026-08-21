#include <stdio.h>
int minusOne = 0;
int zero = 0;
int plusOne = 0;
int buildTree(int left, int right)
{
    if (left > right)
        return 0;
    int mid = (left + right) / 2;
    int leftHeight = buildTree(left, mid - 1);
    int rightHeight = buildTree(mid + 1, right);
    int balance = rightHeight - leftHeight;
    if (balance == -1)
        minusOne++;
    else if (balance == 0)
        zero++;
    else if (balance == 1)
        plusOne++;
    if (leftHeight > rightHeight)
        return leftHeight + 1;
    else
        return rightHeight + 1;
}
int main()
{
    int n;
    scanf("%d", &n);
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    buildTree(0, n - 1);
    printf("%d %d %d\n", minusOne, zero, plusOne);
    return 0;
}