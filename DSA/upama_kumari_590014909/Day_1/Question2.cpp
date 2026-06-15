#include<iostream>
#include<vector>
using namespace std;
int sum_array(vector<int>&nums){
    int n=nums.size();
    int sum=0;
    for(int i=0;i<n;i++){
        sum = sum + nums[i];
    }
    return sum;
}
int main(){
    vector<int>nums = {1,2,3,4,5};
    cout<<"sum of the array : "<<sum_array(nums);
    return 0;
}
