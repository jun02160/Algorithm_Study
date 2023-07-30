#include <iostream>

using namespace std;

int N, S;
int result;
int num[20];

void dfs(int i, int x) {  // 재귀를 이용한 dfs로 구현

    if (i == N) return;  // 종료조건
    if (x+num[i] == S) result++;

    dfs(i+1, x);
    dfs(i+1, x+num[i]);
}

int main() {

    cin >> N >> S;

    for (int i=0; i<N; i++) cin >> num[i];

    result = 0;
    dfs(0, 0);

    cout << result << endl;
}
