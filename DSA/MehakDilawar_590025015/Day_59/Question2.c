//Write an efficient function that counts the number of root-to-leaf paths in a binary tree 
//(given in heap-array format with -1 for missing nodes) whose digits can be rearranged into a palindrome.
//Input: tree = [2, 3, 1, 3, 1, -1, 1]. Output: 2.
#include <stdio.h>
int countPaths(int tree[], int n, int index, int mask) {
    if (index >= n || tree[index] == -1)
        return 0;

    mask ^= (1 << tree[index]);
    int left = 2 * index + 1;
    int right = 2 * index + 2;

    if ((left >= n || tree[left] == -1) &&
        (right >= n || tree[right] == -1)) {
        if ((mask & (mask - 1)) == 0)
            return 1;
        return 0;
    }

    return countPaths(tree, n, left, mask) +
           countPaths(tree, n, right, mask);
}

int main() {
    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    int tree[n];
    printf("Enter tree in heap-array format (-1 for missing nodes):\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &tree[i]);
    int result = countPaths(tree, n, 0, 0);
    printf("Number of valid paths: %d\n", result);
return 0;
}