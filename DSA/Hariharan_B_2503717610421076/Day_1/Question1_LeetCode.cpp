#include <iostream>
using namespace std;

class Solution
{
public:
    int missingNumber(vector<int> &nums)
    {
        int n = nums.size();
        int x = 0, a;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == nums[j])
                {
                    x = 1;
                    break;
                }

                else
                {
                    x = 0;
                }
            }
            if (x == 0)
            {
                a = i;
                break;
            }
        }
        return a;
    }
};
