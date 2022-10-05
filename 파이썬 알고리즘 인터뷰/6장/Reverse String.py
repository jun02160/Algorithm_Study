### LeetCode 문제 https://leetcode.com/problems/reverse-string/
from typing import List

class Solution:
    def reverseString(self, s: List[str]) -> None:
        idx = len(s)-1
        for c in range(0,len(s)//2):
            temp = s[c]
            s[c] = s[idx-c]
            s[idx-c] = temp
        print(s)

    def swapString(self, s: List[str]) -> None:
        left, right = 0, len(s)-1
        while left < right:   # 리스트 내부의 범위를 좁혀나가는 두 방향의 포인터
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1

        print(s)


result = Solution()
result.reverseString(["h","e","l","l","o"])
result.swapString(["h","e","l","l","o"])