<h2 align="center">Week 9 Day 61 (14/08/2026)</h2>

## 1. Find the Town Judge (LeetCode #997)

### Solution

```c
#include <stdio.h>
#include <stdlib.h>

int findJudge(int n, int trust[][2], int trustSize) {
    int *score = calloc(n + 1, sizeof(int));

    for (int i = 0; i < trustSize; i++) {
        int a = trust[i][0], b = trust[i][1];
        score[a]--; // a trusts someone -> not a candidate judge
        score[b]++; // b is trusted by someone
    }

    int judge = -1;
    for (int i = 1; i <= n; i++) {
        if (score[i] == n - 1) { judge = i; break; }
    }

    free(score);
    return judge;
}

int main(void) {
    int t1[][2] = {{1,2}};
    printf("%d\n", findJudge(2, t1, 1)); // 2

    int t2[][2] = {{1,3},{2,3}};
    printf("%d\n", findJudge(3, t2, 2)); // 3

    int t3[][2] = {{1,3},{2,3},{3,1}};
    printf("%d\n", findJudge(3, t3, 3)); // -1

    return 0;
}
```

How it works: give every person a `score` that decreases by 1 each time they trust someone (disqualifying them, since the judge trusts nobody) and increases by 1 each time someone trusts them. The town judge — if one exists — is the unique person trusted by everyone else and trusting no one, so their final score is exactly `n - 1`.

Complexity: O(n + trust.length) time, O(n) extra space.

---

## 2. The Wizard Academy

### Solution

Key insight: a group can never contain both a student and any of their mentors (direct or indirect), but it *can* contain unrelated students or siblings freely. That means the minimum number of groups needed equals the length of the **longest mentorship chain** in the forest — every student can simply be grouped by their depth in that chain (all students at chain-depth `d` go in group `d`), and no two students in the same group can be ancestor/descendant of each other.

```c
#include <stdio.h>
#include <string.h>

#define MAXN 2001

int mentorArr[MAXN]; // 0-indexed: mentorArr[i] is student (i+1)'s mentor label, or -1
int memo[MAXN];       // memo[label] = depth of that student in their mentorship chain

int depthOf(int label) {
    if (memo[label] != 0) return memo[label];

    int m = mentorArr[label - 1];
    if (m == -1) return memo[label] = 1;

    return memo[label] = 1 + depthOf(m);
}

int minGroups(int n) {
    memset(memo, 0, sizeof(memo));
    int best = 0;

    for (int label = 1; label <= n; label++) {
        int d = depthOf(label);
        if (d > best) best = d;
    }
    return best;
}

int main(void) {
    int m1[] = {-1, 1, 2, 1, -1};
    memcpy(mentorArr, m1, sizeof(m1));
    printf("%d\n", minGroups(5)); // 3

    int m2[] = {-1, 1, 2};
    memcpy(mentorArr, m2, sizeof(m2));
    printf("%d\n", minGroups(3)); // 3

    int m3[] = {-1, -1, -1, -1};
    memcpy(mentorArr, m3, sizeof(m3));
    printf("%d\n", minGroups(4)); // 1

    return 0;
}
```

How it works: `depthOf(label)` walks up the mentor chain recursively, memoizing each student's depth (root-mentors have depth 1) so no chain is ever re-walked more than once across the whole forest. The answer is simply the maximum depth found across all `n` students — that's how many distinct "levels" the tallest mentorship chain requires.

Complexity: O(n) time overall (memoization ensures each student's depth is computed once), O(n) extra space for the memo table.
