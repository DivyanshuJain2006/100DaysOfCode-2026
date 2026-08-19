#include <stdio.h>
int countPaths(int tree[], int n, int index, int count[]) {
    if (index >= n || tree[index] == -1)
        return 0;
    count[tree[index]]++;
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    if ((left >= n || tree[left] == -1) &&
        (right >= n || tree[right] == -1)) {
        int odd = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i] % 2 == 1)
                odd++;
        }
        count[tree[index]]--;
        if (odd <= 1)
            return 1;
        else
            return 0;
    }
    int answer = 0;
    answer += countPaths(tree, n, left, count);
    answer += countPaths(tree, n, right, count);
    count[tree[index]]--;
    return answer;
}
int main() {
    int t;
    scanf("%d", &t);
    while (t--) {
        int n;
        scanf("%d", &n);
        int tree[n];
        for (int i = 0; i < n; i++)
            scanf("%d", &tree[i]);
        int count[10] = {0};
        int answer = countPaths(tree, n, 0, count);
        printf("%d\n", answer);
    }
    return 0;
}