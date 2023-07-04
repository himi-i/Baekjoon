#include <iostream>
#include <algorithm>
using namespace std;
int RGB[1001][3];
int main() {
    ios::sync_with_stdio(false); cin.tie(nullptr);
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        int R, G, B;
        cin >> R >> G >> B;
        RGB[i][0] = min(RGB[i-1][1], RGB[i-1][2]) + R;
        RGB[i][1] = min(RGB[i-1][0], RGB[i-1][2]) + G;
        RGB[i][2] = min(RGB[i-1][0], RGB[i-1][1]) + B;
    }
    cout << min({RGB[n][0], RGB[n][1], RGB[n][2]});
}