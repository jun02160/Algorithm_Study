// 문자의 최대 크기가 N일 때, 나올 수 있는 모든 경우의 수를 배열에 저장하고 해당 인덱스 + 1 로 값을 찾는다.
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Dict {
    string alpha[5] = {"A","E","I","O","U"};
    vector<string> dict;
    string word;
public:
    Dict(string w);   // 찾을 단어를 매개변수로 넘겨받아 객체 인스턴스 생성
    void add(int maxlen, string temp);   // 사전에 정렬되는 순서를 반영
    int findWord();
};

Dict::Dict(string w) : word(w) {}
void Dict::add(int maxlen, string temp) {
    if (maxlen == temp.size()) {
        dict.push_back(temp);
        return;
    }
    for (int i=0; i<5; i++) 
        add(maxlen, temp+alpha[i]);  // 재귀호출 방식
}
int Dict::findWord() {
    int findIndex = 0; 
    for (int i=1; i<=5; i++)
        add(i, "");   // 사전에 추가할 단어의 최대 길이와 빈 문자열을 넘겨준다. 

    sort(dict.begin(), dict.end());   // 만들어진 사전 정렬
    findIndex = find(dict.begin(), dict.end(), word) - dict.begin() + 1;
    return findIndex;
}

int solution(string word) {
    Dict mydict(word);
    return mydict.findWord();
}

int main() {
    string word = "AAAE";
    cout << solution(word) << endl;
}
