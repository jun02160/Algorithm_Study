## 개념

### 스택 (Stack)

> LIFO: Last-In-First-Out (후입선출)
> 

*대부분의 애플리케이션 개발에서 사용

- push() : 요소를 컬렉션에 추가
- pop() : 아직 제거되지 않은 가장 최근에 삽입된 요소를 제거

### 연결 리스트를 이용한 스택의 ADT

```python
class Node:
    def __init__(self, item, next):
        self.item = item    # 노드의 값
        self.next = next    # 다음 노드를 가리키는 포인터

class Stack:
    def __init__(self):
        self.last = None    # 리스트의 마지막 요소를 가리키는 포인터

    # 리스트의 마지막에 요소를 추가하는 함수
    def push(self, item):
        self.last = Node(item, self.last)   # 연결 리스트에 요소를 추가하면서 가장 마지막 값을 next로 지정

    # 리스트의 마지막 요소를 삭제하는 함수
    def pop(self):
        item = self.last.item   # 마지막 요소를 가져오고
        self.last = self.last.item   # 포인터를 한 칸 이전으로 전진시켜 이전에 추가된 값을 가리키게 함
        return item
```

### 큐 (Queue)

> FIFO: First-In-First-Out (선입선출)
> 

*리스트는 큐의 모든 연산을 지원하며, 큐의 연산을 수행하려면 데크(Deque)라는 별도의 자료형을 사용해야 좋은 성능을 낼 수 있다. 

---

# 유효한 괄호

[Valid Parentheses - LeetCode](https://leetcode.com/problems/valid-parentheses/)

## Problem

괄호로 된 입력값이 올바른지 출력하는 문제

### ISSUE

- 괄호 쌍이 올바르게 짝지어져 있는지 검사한다.
- 스택 구조를 이용하면 닫힌 괄호가 pop 된 후에 처음 등장하는 열린 괄호가 같은 종류여야 한다.
- 스택을 이용하기 위해 루프를 마지막 인덱스부터 돈다.
- 풀이
    
    ```python
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
    
    result = Solution()
    print(result.isValid("(){}[]"))
    print(result.isValid("(){{}[]"))
    print(result.isValid("(]"))
    ```
    

## Solution

### 1. 스택 일치 여부 판별

열린 괄호는 스택에 푸시하고 닫힌 괄호를 만날 때 스택에서 팝한 결과가 미리 정의해둔 매핑 테이블의 결과와 매칭되는지 확인하면 된다. 

- 리턴 시에 스택에 남아있는 것이 없어야 True이므로, *`return len*(stack) == 0` 으로 if문 없이 한 번에 작성할 수 있다