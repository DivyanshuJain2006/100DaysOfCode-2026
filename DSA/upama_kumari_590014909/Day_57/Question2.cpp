#include <iostream>
#include <vector>
using namespace std;

bool isMirror(vector<long long>& a, vector<long long>& b, int i, int j) {

    bool missingA = (i >= a.size() || a[i] == -1);
    bool missingB = (j >= b.size() || b[j] == -1);

    if (missingA && missingB) {
        return true;
    }

    if (missingA || missingB) {
        return false;
    }

    if (a[i] != b[j]) {
        return false;
    }

    return isMirror(a, b, 2 * i + 1, 2 * j + 2) &&
           isMirror(a, b, 2 * i + 2, 2 * j + 1);
}

int main() {
    
    int t;
    cin >> t;

    while (t--) {
        
        int n1;
        cin >> n1;

        vector<long long> warehouse1(n1);

        for (int i = 0; i < n1; i++) {
            cin >> warehouse1[i];
        }

        int n2;
        cin >> n2;

        vector<long long> warehouse2(n2);

        for (int i = 0; i < n2; i++) {
            cin >> warehouse2[i];
        }

        if (isMirror(warehouse1, warehouse2, 0, 0)) {
            cout << "YES" << endl;
        }
        else {
            cout << "NO" << endl;
        }
    }

    return 0;
}