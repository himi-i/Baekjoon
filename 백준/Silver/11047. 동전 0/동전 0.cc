#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N,k,ans;
int coin[11];

int main(){
    
    cin >> N >> k;
    for(int i=0; i<N; i++){
        cin >> coin[i];
    }
    for(int i = N-1; i>=0; i--){
        ans += k / coin[i];
        k %= coin[i];

    }

cout << ans;

}