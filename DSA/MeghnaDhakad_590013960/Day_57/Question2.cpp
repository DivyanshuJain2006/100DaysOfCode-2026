#include <iostream>
#include <vector>
using namespace std;

bool isMirror(const vector<int>& a, const vector<int>& b,
              int i, int j) {

    // Missing nodes
    if (i >= a.size() || j >= b.size())
        return i >= a.size() && j >= b.size();

    if (a[i] == -1 || b[j] == -1)
        return a[i] == b[j];

    // Values must match
    if (a[i] != b[j])
        return false;

    // Left of first ↔ Right of second
    // Right of first ↔ Left of second
    return isMirror(a, b, 2 * i + 1, 2 * j + 2) &&
           isMirror(a, b, 2 * i + 2, 2 * j + 1);
}

int main() {
    vector<int> warehouse = {1, 2, 3};
    vector<int> warehouse2 = {1, 3, 2};

    if (isMirror(warehouse, warehouse2, 0, 0))
        cout << "YES";
    else
        cout << "NO";

    return 0;
}