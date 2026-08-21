#include <iostream>
#include <vector>
using namespace std;

int countBalance(vector<int>& arr, int left, int right,
                 int& minusOne, int& zero, int& plusOne) {
    
    if (left > right)
        return 0;


    int mid = (left + right) / 2;
    int leftHeight = countBalance(arr, left, mid - 1,
                                  minusOne, zero, plusOne);

    int rightHeight = countBalance(arr, mid + 1, right,
                                   minusOne, zero, plusOne);

    int balanceFactor = leftHeight - rightHeight;

    if (balanceFactor == -1)
        minusOne++;
    else if (balanceFactor == 0)
        zero++;
    else if (balanceFactor == 1)
        plusOne++;

    return 1 + max(leftHeight, rightHeight);
}

