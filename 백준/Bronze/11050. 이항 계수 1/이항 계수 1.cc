#include <iostream>
using namespace std;

int factorial(int num) {
    if (num == 1 || num == 0) return 1;
    else return factorial(num-1) * num;
}

int main() {

    int n, k;
    cin >> n >> k;
    cout << factorial(n) / (factorial(k)*factorial(n-k)) << endl;
}