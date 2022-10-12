import collections
import re
from typing import Deque


def isPalindrome(s: str) -> bool:
    s = s.lower()
    str_list = []
    for c in s:
        if c.isalnum():
            str_list.append(c)
    for i in range(len(str_list)):
        # print(str_list[i])
        # print(str_list[len(str_list) - i - 1])
        if str_list[i] != str_list[len(str_list) - i - 1]:
            return False
    return True

def dequeIsPalindrome(self, s: str) -> bool:
    # 자료형 데크로 선언
    strs: Deque = collections.deque()

    for char in s:
        if char.isalnum():
            strs.append(char.lower())

    while len(strs) > 1:
        if strs.popleft() != strs.pop():
            return False

    return True

def slicingIsPalindrome(self, s: str) -> bool:
    s = s.lower()
    #정규식을 이용해 불필요한 문자열 필터링
    s = re.sub('[^a-z0-9]', '', s)

    return s == s[::-1]

print(isPalindrome("A man, a plan, a canal: Panama"))
print(isPalindrome("race a car"))