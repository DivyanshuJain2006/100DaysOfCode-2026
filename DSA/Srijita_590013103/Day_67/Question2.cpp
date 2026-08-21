#include <algorithm>
#include <array>
#include <iostream>
using namespace std;

struct Result {
    int height;
    array<long long, 3> count;
};

Result calculate(int length) {
    if (length == 0)
        return {0, {0, 0, 0}};

    int leftSize = (length - 1) / 2;
    int rightSize = length - 1 - leftSize;

    Result left = calculate(leftSize);
    Result right = calculate(rightSize);

    Result result;
    result.height = 1 + max(left.height, right.height);

    for (int i = 0; i < 3; ++i)
        result.count[i] = left.count[i] + right.count[i];

    int balanceFactor = right.height - left.height;

    ++result.count[balanceFactor + 1];

    return result;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    long long value;
    for (int i = 0; i < n; ++i)
        cin >> value;

    Result answer = calculate(n);

    cout << answer.count[0] << ' '
         << answer.count[1] << ' '
         << answer.count[2] << '\n';

    return 0;
}