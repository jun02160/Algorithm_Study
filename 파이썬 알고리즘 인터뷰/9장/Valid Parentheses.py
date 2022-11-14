class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        result = True
        parentheses = {
            "}": "{",
            "]": "[",
            ")": "("
        }
        ##
        for i in range(len(s)-1, -1, -1):
            if s[i] in parentheses.keys():   # 닫힌 괄호일 때
                stack.append(s[i])
            elif s[i] in parentheses.values():  # 열린 괄호일 때
                if len(stack) == 0:
                    return False
                char = stack.pop()
                if parentheses[char] != s[i]:
                    return False

        if len(stack) != 0:
            result = False
        return result

    # 교재 풀이
    def isValid(self, s: str) -> bool:
        stack = []
        table = {
            "}": "{",
            "]": "[",
            ")": "("
        }

        # 스택 이용 예외 처리 및 일치 여부 판별
        for char in s:
            if char not in table:
                stack.append(char)
            elif not stack or table[char] != stack.pop():
                return False
        return len(stack) == 0

result = Solution()
print(result.isValid("(){}[]"))
print(result.isValid("(){{}[]"))
print(result.isValid("(]"))