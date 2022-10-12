### LeetCode 문제 https://leetcode.com/problems/group-anagrams/
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        strs.sort()
        result = []    # 결과를 저장할 2차원 배열

        dic = {}
        for idx in range(0, len(strs)):
            ch = []
            for i in strs[idx]:
                ch.append(i)
            ch.sort()
            dic[idx] = ch

        dic_set = self.makeDict(dic)
        for s in dic_set:
            temp = []
            for key, value in dic.items():
                if s == value:
                    temp.append(strs[key])
            result.append(temp)

        result.sort(key=lambda x: (len(x)))

        return result

    # Dicionary 의 Value -> Set 처럼 구현
    def makeDict(self, dic):
        res = []
        for v in dic.values():
            if v not in res:
                res.append(v)
        return res

result = Solution()
print(result.groupAnagrams(["eat","tea","tan","ate","nat","bat"]))
print(result.groupAnagrams(["a"]))


