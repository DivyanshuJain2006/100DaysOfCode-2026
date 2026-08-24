#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin >> n;

    vector<string> goals(n);

    for (int i = 0; i < n; i++)
    {
        cin >> goals[i];
    }

    string team1 = goals[0];
    string team2 = "";

    for (int i = 1; i < n; i++)
    {
        if (goals[i] != team1)
        {
            team2 = goals[i];
            break;
        }
    }

    int count1 = count(goals.begin(), goals.end(), team1);
    int count2 = count(goals.begin(), goals.end(), team2);

    if (count1 > count2)
        cout << team1 << endl;
    else
        cout << team2 << endl;

    return 0;
}
