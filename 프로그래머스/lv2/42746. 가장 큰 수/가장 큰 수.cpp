#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class BigNum {
    vector<int> numbers;
    vector<string> comb;   // 주어진 정수들로 만들 수 있는 조합을 저장 (문자열 이어붙이기로)
    string compareNum(string s1, string s2);
    void makeStr(vector<int> nums);
public:
    BigNum(vector<int> nums);  // constructor
    static bool scompare(string s1, string s2);
    string getMaxNum();
};

BigNum::BigNum(vector<int> nums) :numbers(nums){
    makeStr(nums);
}
void BigNum::makeStr(vector<int> nums) {
    for (int i=0; i<nums.size(); i++) {
        comb.push_back(to_string(nums[i]));
    }
    sort(comb.begin(), comb.end(), scompare);   // 사용자 정의 기준으로 벡터 정렬
}
bool BigNum::scompare(string s1, string s2) {
    return s1+s2 > s2+s1;
}
string BigNum::compareNum(string s1, string s2) {
    // 문자열의 길이로 먼저 비교 후
    if (s1.length() > s2.length()) return s1;
    else if (s1.length() < s2.length()) return s2;
    else {
        // 정수로 변환하여 숫자 자체의 대소비교
        long long n1 = stoll(s1);
        long long n2 = stoll(s2);
        if (n1 >= n2) return s1;
        else return s2;
    }
}
string BigNum::getMaxNum() {
    // for (int i=0; i<comb.size(); i++) {
    //     cout << "comb["<<i<<"]= " << comb[i]<<endl;
    // }
    
    string maxnum = "";
    if (comb[0]=="0") return "0";
    for (int i=0; i<comb.size(); i++) {
        maxnum += comb[i];
        // cout << "comb["<<i<<"]= " << comb[i]<<endl;
    }
    return maxnum;
}

string solution(vector<int> numbers) {
    string answer = "";
    BigNum mynum(numbers);
    answer = mynum.getMaxNum();
    return answer;
}

