#include <iostream>

using namespace std;


int main() {

    int num[8];
    int asc = 0, desc = 8;
    for (int i=0; i<8; i++) {
        cin >> num[i];

        if (num[i] == i+1) asc++;
        else if (num[i] == 8-i) desc--;
    }
    
    if (asc == 8) cout << "ascending" << endl;
    else if (desc == 0) cout << "descending" << endl;
    else cout << "mixed" << endl;
}