#include <iostream>
#include <vector>
using namespace std;

int main() {
    int j, num;
    
    while (1) {
    
        cin >> num;
        if (num == -1) break;

        vector<int> numList;
        int sum = 0;
        
        for (int i=1; i<=num; i++) {
            if (num % i == 0) {
                numList.push_back(i);
                sum += i;
            }
        }
        if (sum - num == num) {
            cout << num << " = ";
            for (j=0; j<numList.size()-2; j++) 
                cout << numList[j] << " + ";
            cout << numList[j] << endl;
        }
        else
            cout << num << " is NOT perfect." << endl;
    }
    
}
