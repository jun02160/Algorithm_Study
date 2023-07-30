#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main() {

    string str;
    char c;

    int L;
    long long hash = 0;
    cin >> L;
    cin >> str;

    for (int i=0; i<str.size(); i++) {
        c = str[i];
        hash += (c-96) * pow(31, i);
    }
    cout << hash << endl;
}