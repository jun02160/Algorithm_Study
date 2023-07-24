#include <iostream>
#include <set>

using namespace std;

int main() {
    
    set<int> numSet;

    int n;
    cin >> n;
    
    for (int i=0; i<n; i++) {
        int num;
        cin >> num;
        numSet.insert(num);
    }
    for (auto i=numSet.begin(); i!=numSet.end(); i++) {
        cout << *i;
        cout << " ";
    }
    
}
