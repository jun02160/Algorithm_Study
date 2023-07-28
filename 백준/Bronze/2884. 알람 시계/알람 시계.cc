#include <iostream>
using namespace std;

int main() {
    int H, M;
    cin >> H;
    cin >> M;
    
    // 45분 전이면 이전으로 돌아가
    if (M < 45) {
        if (H == 0) { // 23 -> 0시
            H = 23;
            M += 60;
        } else {  // 이외는 1 -> 24시까지 단위로
            H -= 1;
            M += 60;
        }
    }
    
    cout << H << " " << M-45 << endl;
}