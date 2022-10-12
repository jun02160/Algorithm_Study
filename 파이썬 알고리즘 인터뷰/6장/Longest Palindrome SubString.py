# Leetcode 문제. https://leetcode.com/problems/longest-palindromic-substring/

class Solution:
    def longestPalindrome(self, s: str) -> str:
        result = []

        if len(s) == 1:
            result.append(s)

        for i in range(0, len(s)-1):
            for j in range(i, len(s)):
                if self.isPalindrome(s[i:j]) and s[i:j] != '':
                    result.append(s[i:j])

        print(result)
        max = result[0]
        for i in result:
            if len(max) < len(i):
                max = i
        return max

    # 특정 문자열에 대해 필린드롬인지 아닌지 검사하는 코드
    def isPalindrome(self, s: str) -> bool:
        return s == s[::-1]

result = Solution()
print(result.longestPalindrome("babad"))
print(result.longestPalindrome("cbbd"))
print(result.longestPalindrome("a"))
print(result.longestPalindrome("bb"))