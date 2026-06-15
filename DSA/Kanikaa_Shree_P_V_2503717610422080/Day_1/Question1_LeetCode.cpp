class Solution {
public:
    int missingNumber(vector<int>& nums)
    {
        int m,a;
        for(int i = 0;i <= nums.size();i++)
        {
            a=1;
         for(int j = 0; j < nums.size();j++)
            {
               if(nums[j] == i)
                {
                    a = 0;
                    break;
                }
            }
            if(a == 1)
            {
                m = i;
                break;
            }
        }
        return m;
    }
};