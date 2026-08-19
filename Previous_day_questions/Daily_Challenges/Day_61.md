<h2 align="center">Week 9 Day 5 (14/08/2026)</h2>

## 1. Find the Town Judge (LeetCode #997)
A problem that teaches graph and in-degree/out-degree counting techniques by identifying a uniquely trusted node in a directed relationship graph. In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge. If the town judge exists, then: the town judge trusts nobody; everybody (except for the town judge) trusts the town judge; and there is exactly one person that satisfies both properties. You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in the trust array, then such a trust relationship does not exist.

This problem is commonly asked in interviews and helps build concepts like:
- Graph in-degree/out-degree counting
- Hash maps / arrays for tallying
- Unique-node identification

which are important for solving relationship-graph and identification problems.

**Your task:** Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

### Input
An integer `n` and an array `trust`, as described above.

**Constraints:**
- `1 <= n <= 1000`
- `0 <= trust.length <= 10^4`
- `trust[i].length == 2`
- All the pairs of trust are unique.
- `ai != bi`
- `1 <= ai, bi <= n`

### Output
Return the label of the town judge, or -1 if the town judge cannot be identified.

### Examples

**Input:**
```
n = 2, trust = [[1,2]]
```
**Output:**
```
2
```

---

**Input:**
```
n = 3, trust = [[1,3],[2,3]]
```
**Output:**
```
3
```

---

**Input:**
```
n = 3, trust = [[1,3],[2,3],[3,1]]
```
**Output:**
```
-1
```

---

## 2. The Wizard Academy
A wizard academy has n students numbered from 1 to n. Each student either has no mentor, or has exactly one direct mentor. The mentor relationships form a hierarchy with no cycles. The academy is organizing a magical ceremony and wants to divide all students into groups. However, there is one important rule: a group cannot contain both a student and any of their mentors. A mentor relationship can be either a direct mentor, or any mentor higher up in the mentorship chain. Every student must belong to exactly one group.

This problem is commonly asked in interviews and helps build concepts like:
- Tree/forest depth computation
- Hierarchy traversal
- Level-based grouping

which are important for solving hierarchy-partitioning and depth-based grouping problems.

**Your task:** Find the minimum number of groups required so that no group contains both a student and any of their mentors.

### Input
An integer `n` and an array `mentor`, as described above.

**Constraints:**
- `1 <= n <= 2000`
- `mentor[i] = -1` or `1 <= mentor[i] <= n`
- `mentor[i] != i`
- It is guaranteed that the mentorship hierarchy contains no cycles.

### Output
Return the minimum number of groups required.

### Examples

**Input:**
```
n = 5
mentor = [-1, 1, 2, 1, -1]
```
**Output:**
```
3
```

---

**Input:**
```
n = 3
mentor = [-1, 1, 2]
```
**Output:**
```
3
```

---

**Input:**
```
n = 4
mentor = [-1, -1, -1, -1]
```
**Output:**
```
1
```

---
