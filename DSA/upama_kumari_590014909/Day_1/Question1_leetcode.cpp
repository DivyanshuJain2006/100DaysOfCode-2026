#include<iostream>
#include<vector>
using namespace std;
int missing_num(vector<int>&nums){
    int n = nums.size();
    int actual_sum = 0;
    int expected_sum = n*(n+1)/2;
    for(int num : nums){
        actual_sum = actual_sum + num;
    }
    return expected_sum - actual_sum;
}
int main(){
    vector<int>nums = {3,0,1};
    cout<<"missing number : "<<missing_num(nums);
    return 0;
}