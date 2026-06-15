#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int> nums = {3, 8, 2, 9, 1};  
    int n = nums.size();
    int sum = 0;
    
    for(int i = 0; i < n; i++) {
        sum += nums[i];
    }
    
    cout << "Sum: " << sum << endl;
    
    return 0;
}