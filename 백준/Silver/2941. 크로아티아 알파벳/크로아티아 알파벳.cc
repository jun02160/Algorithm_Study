#include <iostream>
#include <string>
using namespace std;

// 크로아티아 알파벳 배열
string* croatia = new string[8]{
    "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
};

int main()
{
    string str;
    cin >> str;

    int cnt = 0;
    for (int i = 0; i < 8; i++)
    {
        while (true) 
        {
            // cout << croatia[i] << endl;
            char index = str.find(croatia[i]);
            if (index == string::npos)
                break;
            str.replace(index, croatia[i].length(), "#");
        }
    }

    cout << str.length() << endl;
}