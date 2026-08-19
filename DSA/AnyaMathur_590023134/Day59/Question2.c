// Problem 2
// The Secret Passcodes 

#include <stdio.h>

int tree[100000];
int n;
int ans;

void dfs(int index, int count[]) {
    if (index >= n || tree[index] == -1)
        return;
    count[tree[index]]++;
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    if ((left >= n || tree[left] == -1) &&
        (right >= n || tree[right] == -1)) {
        int odd = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i] % 2 != 0)
                odd++;
        }
        if (odd <= 1)
            ans++;
    }
    else {
        dfs(left, count);
        dfs(right, count);
    }
    count[tree[index]]--;
}

int main() {
    int t;
    printf("Enter number of test cases: ");
    scanf("%d", &t);
    while (t--) {
        printf("Enter size of tree: ");
        scanf("%d", &n);
        printf("Enter tree elements: ");
        for (int i = 0; i < n; i++)
            scanf("%d", &tree[i]);
        int count[10] = {0};
        ans = 0;
        dfs(0, count);
        printf("Number of valid passcodes: %d\n", ans);
    }
    return 0;
}