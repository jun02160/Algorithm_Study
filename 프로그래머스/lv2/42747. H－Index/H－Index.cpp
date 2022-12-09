#include <iostream>
#include <string>
#include <vector>
#include <algorithm>


using namespace std;

class HIndex {
    vector<int> cit;
    int bigCnt, smallCnt;
    void getCount(int index);
public:
    HIndex(vector<int> citations);
    int findH();
};

HIndex::HIndex(vector<int> citations):cit(citations){ 
    bigCnt = 0; smallCnt = 0;
}

void HIndex::getCount(int index) {
    bigCnt = 0;
    smallCnt = 0;
    for (int i=0; i<cit.size(); i++) {
        if (cit[i] >= index) bigCnt++;
        if (cit[i] <= index) smallCnt++;
    }
}

int HIndex::findH() {
    sort(cit.begin(),cit.end(), greater<int>());   // 벡터 내림차순 정렬
    int cnt = 0;
    if (cit[0] == 0) return 0;
    for (int i=0; i<cit.size(); i++) {
        if (cit[i] >= i+1) cnt = i+1;
        else break;
        // int idx = cit[i];
        // getCount(idx);
        // cout << "idx: "<<idx << bigCnt << ' ' << smallCnt << endl;
        // if (idx == bigCnt && idx == smallCnt) return idx;
        // if (idx < bigCnt) return cit[i-1];
    }
    return cnt;
    // return cit[cit.size()-1];
}


int solution(vector<int> citations) {
    int answer = 0;
    HIndex myh(citations);
    answer = myh.findH();
    return answer;
}

int main() {
    vector<int> citations = {3,0,6,1,5};
    HIndex myh(citations);
    cout << myh.findH() << endl;;
}
