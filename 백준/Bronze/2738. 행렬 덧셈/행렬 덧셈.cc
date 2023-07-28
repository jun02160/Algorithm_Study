#include <iostream>

using namespace std;

int main() {
    int N, M;
    cin >> N;
    cin >> M;
    
    int arr[N][M];
    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            cin >> arr[i][j];
        }
    }
    
    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            int temp;
            cin >> temp;
            arr[i][j] += temp;
        }
    }
    
    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
}
