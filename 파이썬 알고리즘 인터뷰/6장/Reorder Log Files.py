### Leetcode 문제. 로그 파일 재정렬 https://leetcode.com/problems/reorder-data-in-log-files/
from typing import List


class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        word, digit = [], []
        for log in logs:
            if log.split(' ')[1].isdigit():
                digit.append(log)
            else:
                word.append(log)

        word.sort(key=lambda x: (x.split(' ')[1:], x.split(' ')[0]))
        return word + digit


result = Solution()
print(result.reorderLogFiles(["dig1 8 1 5 1", "let1 art cab"]))
