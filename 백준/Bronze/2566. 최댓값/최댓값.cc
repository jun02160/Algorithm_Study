#include <iostream>

using namespace std;


int main() {

    int num[9][9];
    for (int i=0; i<9; i++) {
        for (int j=0; j<9; j++) {
            cin >> num[i][j];
        }
    }

    int max = num[0][0];
    int rowIdx = 0;
    int colIdx = 0;
    for (int i=0; i<9; i++) {
        for (int j=0; j<9; j++) {
            if (num[i][j] > max) {
                max = num[i][j];
                rowIdx = i;
                colIdx = j;
            }
        }
    }
    cout << max << endl << rowIdx+1 << " " << colIdx+1 << endl;
}