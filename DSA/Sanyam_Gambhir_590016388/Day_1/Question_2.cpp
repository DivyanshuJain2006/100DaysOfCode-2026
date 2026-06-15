#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
    int calculatesum(vector<int>& nums) {
        int sum = 0;
        for(int i = 0; i < nums.size(); i++) {
            sum += nums[i];
        }
        return sum;
    }
};

int main() {
    Solution solution;
    vector<int> nums = {1, 2, 3, 4, 5};
    int result = solution.calculatesum(nums);
    cout << "The sum of the array is: " << result << endl;
    return 0;
}