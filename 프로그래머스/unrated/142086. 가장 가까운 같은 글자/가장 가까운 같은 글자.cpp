#include <string>
#include <vector>
#include <iostream>

using namespace std;

class Word {
    string str;
    vector<char> wordlist;
    vector<int> idxlist;
    bool isIn(char c);
    bool isOne(int idx);  // 개수 1개인지 세기
    void setWord();
public:
    Word(string s);
    vector<int> getDis();
};

Word::Word(string s) :str(s) { setWord(); }
void Word::setWord() {
    for (int i=0; i<str.size(); i++) {
        if (!isIn(str[i])) {
            wordlist.push_back(str[i]);
            idxlist.push_back(i);
        } 
    }
}
bool Word::isOne(int idx) {
    for (int i=str.length()-1; i>=0; i--) {
        if (i > idx && str[idx]==str[i]) return false; 
    }
    return true;
}
bool Word::isIn(char c) {
    for (int i=0; i<wordlist.size(); i++) 
        if(wordlist[i] == c) return true;
    return false;
}

vector<int> Word::getDis() {
    vector<int> distance;
    for (int i=0; i<str.length(); i++) {
        for (int j=0; j<wordlist.size(); j++) {
            if ((i==idxlist[j] && wordlist[j] == str[i])) {
                distance.push_back(-1); 
                break;
            }
            else if (wordlist[j] == str[i]) {
                distance.push_back(i-idxlist[j]);
                idxlist[j] = i;
                break;
            } 
           
        }
    }
    return distance;
}
vector<int> solution(string s) {
    Word myword(s);
    vector<int> answer = myword.getDis();
    return answer;
}
