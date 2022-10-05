### leetcode 문제. 가장 흔한 단어 https://leetcode.com/problems/most-common-word/
import collections
import re
from typing import List


class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        paragraph.replace(',', ' ')
        paragraph.replace('.', ' ')
        words = paragraph.split(' ')   # 공백을 기준으로 분리하여 단어 배열 생성
        dict_word = {}
        for word in words:
            word.lower()
            if word in dict_word:
                dict_word[word] += 1
            else:
                dict_word[word] = 1   # 해당 단어를 Key로 하고 개수 1을 Value로 초기화하여 딕셔너리에 요소 추가

        sorted(dict_word, reverse=False)
        print(dict_word)

        for val in dict_word.keys():
            if val not in banned:
                return val

    def mostCommonWord2(self, paragraph: str, banned: List[str]) -> str:
        words = [word for word in re.sub(r'[^\w]', ' ', paragraph).lower().split()
                 if word not in banned]   # List Comprehension
        counts = collections.defaultdict(int)
        for word in words:
            counts[word] += 1

        return max(counts, key=counts.get)

    def mostCommonWord3(self, paragraph: str, banned: List[str]) -> str:
        words = [word for word in re.sub(r'[^\w]', ' ', paragraph).lower().split()
                 if word not in banned]   # List Comprehension

        counts = collections.Counter(words)
        # 최다 빈도로 등장하는 단어의 첫 번째 인덱스 리턴
        # print(counts)
        # print(counts.most_common(1))
        # print(counts.most_common(2)[0])

        return counts.most_common(1)[0][0]


result = Solution()
print(result.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", ["hit"]))
print(result.mostCommonWord2("Bob hit a ball, the hit BALL flew far after it was hit.", ["hit"]))
print(result.mostCommonWord3("Bob hit a ball, the hit BALL flew far after it was hit.", ["hit"]))