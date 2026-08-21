//Need to find the minimum groups so students never share a group with their mentors

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n = 5;
    vector<int> mentor = {-1, 1, 2, 1, -1};

    vector<vector<int>> graph(n + 1);

    for (int i = 1; i <= n; i++)
    {
        if (mentor[i - 1] != -1)
        {
            graph[i].push_back(mentor[i - 1]);
            graph[mentor[i - 1]].push_back(i);
        }
    }

    vector<int> color(n + 1, -1);
    int groups = 0;

    for (int start = 1; start <= n; start++)
    {
        if (color[start] != -1)
            continue;

        vector<int> q = {start};
        color[start] = 0;

        int best = 1;

        for (int level = 0; level < q.size(); level++)
        {
            int node = q[level];

            for (int next : graph[node])
            {
                if (color[next] == -1)
                {
                    color[next] = color[node] ^ 1;
                    q.push_back(next);
                }
            }
        }

        groups = max(groups, 2);
    }

    cout << groups;

    return 0;
}
