#include <iostream>
using namespace std;

int main() {

    string str;
    int L;
    long sum = 0, pow = 1;
    long MOD = 1234567891;
    cin >> L;
    cin >> str;

    for (int i=0; i<str.size(); i++) {
        char c;
        c = str[i];
        sum += (str[i] - 'a' + 1) * pow % MOD;
        pow = pow * 31 % MOD;
    }
    long hash = sum % MOD;
    cout << hash << endl;
}