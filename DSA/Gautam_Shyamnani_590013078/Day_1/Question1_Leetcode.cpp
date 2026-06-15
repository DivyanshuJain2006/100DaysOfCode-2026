class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int ExpectedSum = n * (n+1) / 2;
        int ActualSum = 0;
        for(int num : nums){
            ActualSum += num;
        }
        return ExpectedSum - ActualSum;
    }
};