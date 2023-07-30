#include <iostream>
#include <string>

using namespace std;

int main() {

    string str;
    cin >> str;

    int len = str.length();
    bool isPalin = true;
    for (int i=0; i<len/2; i++) {
        if (str[i] != str[len-i-1]) isPalin = false;
    }
    if (isPalin) cout << 1 << endl;
    else cout << 0 << endl;
}
