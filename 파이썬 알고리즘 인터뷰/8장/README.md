- 파이썬으로 연결리스트(***********LinkedList***********) 구현하기
    
    ```python
    ### 파이썬으로 Linked List 자료구조 구현하기
    
    # 노드 구현
    class Node:
        def __init__(self, data):
            self.data = data
            self.next = None
            
    # Linked List 구현
    class LinkedList:
        def __init__(self, data):
            self.head = Node(data)
            
        # 헤더부터 탐색하여 맨 뒤에 새로운 노드 추가하기
        def append(self, data):
            cur = self.head
            while cur.next is not None:   # 마지막 노드가 아니라면
                cur = cur.next   # 노드 전진
            cur.next = Node(data)   # 마지막 노드에 새로운 노드 이어주기
    
        # 특정 위치에 노드 추가(삽입)하기
        def add_node(self, index, value):
            new_node = Node(value)
            if index == 0:   # 리스트의 맨 앞에 추가하는 경우 (헤더 노드의 갱신도 필요)
                new_node.next = self.head
                self.head = new_node
                return
            node = self.get_node(index - 1)
            next_node = node.next
            node.next = new_node
            new_node.next = next_node
    
        # 특정 노드 삭제하기
        def delete_node(self, index):
            if index == 0:
                self.head = self.head.next
                return
            node = self.get_node(index-1)  # 삭제할 노드의 이전 노드 찾기
            node.next = node.next.next  # 삭제할 노드를 건너뛰고 연결해준다.
    
        # 모든 노드 출력하기
        def print_all(self):
            cur = self.head  # 헤더노드부터 순회 시작
            while cur is not None:
                print(cur.data)
                cur = cur.next   # 노드 전진
    
        # 노드의 인덱스 찾기
        def get_node(self, index):
            cnt = 0
            node = self.head
            while cnt < index:
                cnt += 1
                node = node.next
            return node
    ```
    

# 팰린드롬 연결 리스트

[Palindrome Linked List - LeetCode](https://leetcode.com/problems/palindrome-linked-list/)

## Problem

연결 리스트가 팰린드롬 구조인지 판별하는 문제

[https://leetcode.com/problems/merge-two-sorted-lists/](https://leetcode.com/problems/merge-two-sorted-lists/)

### ISSUE

- 연결리스트를 이루는 노드의 데이터들이 좌우 대칭인지 확인
- 연결리스트의 전체 길이를 판단하고 중간값을 기준으로 양쪽이 같다면 팰린드롬이다.
    - 이때, 주어진 자료구조는 연결리스트이므로, 인덱스의 임의 접근이 불가능하고 오로지 바로 다음 노드와의 연결만이 가능하다.
- 앞뒤로 모두 추출할 수 있는 자료구조가 필요하다.

## Solution

### 1. 리스트 변환

파이썬의 리스트는 pop()으로 마지막 원소 뿐만 아니라 원하는 위치의 값을 자유롭게 추출할 수 있어 연결 리스트를 파이썬의 리스트로 변환하여 기능을 이용하면 쉽게 풀이할 수 있다. 

- `while node is not None:`  - 리스트의 마지막 노드인지 검사 (마지막 노드는 Null을 가리키는 특징)
- `node = [node.next](http://node.next)`  - 다음 노드로 전진 (리스트 내부를 순회하며 전진한다.)
- `if q.pop(0) ≠ q.pop(): return False`  - 리스트의 맨 처음과 마지막 요소만 비교하여 팰린드롬인지 판별할 수 있다. (pop() 함수가 리스트에서 원소를 삭제하고, 그 원소를 반환한다는 기능을 가지기 때문)

### 2. 데크를 이용한 최적화

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/652cf447-f8cb-4b1a-909a-002c48b29f07/Untitled.png)

동적 배열로 구성된 리스트는 맨 앞의 아이템을 가져오기에 효율적이지 않아 속도가 느리다. 첫 번째 값을 가져오기 위해서는 모든 값을 한 칸씩 Shifting하며 이는 시간 복잡도 O(n)을 가지기 때문이다. 

이를 최적화하기 위해 O(n) 이내에 첫 번째 요소를 가져올 수 있는 자료구조 중 하나가 바로 파이썬의 데크이다. 데크(*****Deque*****)는 이중 연결 리스트 구조로, 양쪽 방향을 모두 추출할 수 있고 시간 복잡도가 O(1)로 단순 연결리스트보다 훨씬 빠르다. 

- *`if* q.popleft() != q.pop():` - 첫 번쨰 요소를 가져오는 함수를 deque()에 내장 함수인 popleft()를 이용해서 O(1)로 줄일 수 있다.

***Deque의 함수와 List의 함수 비교**

![Deque는 List보다 훨씬 많은 기능을 빠른 속도로 제공한다. ](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ec887ba9-7d70-483f-b3a2-9f6b5018d9f4/Untitled.png)

Deque는 List보다 훨씬 많은 기능을 빠른 속도로 제공한다. 

### 3. 런너를 이용한 풀이

Runner 기법이 팰린드롬 연결 리스트 문제의 제대로 된 풀이법이라고 할 수 있다. 

****Runner 기법***
연결 리스트를 순회할 때 2개의 포인터를 동시에 사용하는 기법으로, 한 포인터가 다른 포인터보다 앞서게 하여 병합 지점이나 중간 위치, 길이 등을 판별할 때 유용하게 사용할 수 있다. 

빠른 런너(Fast Runner)와 느린 런너(Slow Runner)를 각각 출발시키면, 빠른 런너가 끝에 다다를 때 느린 런너는 정확히 중간 지점에 도착하게 된다. 

- 빠른 런너는 next가 존재하지 않는 끝까지 이동하며, 빠른 런너가 도착하기 전까지 2칸씩, 느린 런너는 1칸씩 전진한다.
    - `**fast** = **fast.next.next**`
    - `rev, rev.next, **slow** = slow, rev, **slow.next**`  - 현재 값을 slow로 교체하고, rev.next는 rev로 이전 값으로 순회한다.
    ****파이썬의 다중할당 사용***
    - `if fast: slow = [slow.next](http://slow.next)` - fast가 None이 아닌데 while문에서 빠져나오지 못하는 경우, 입력값이 홀수라 중앙값은 단 하나만 존재하게 되는 상황에서 slow 런너가 중앙의 값을 빗겨 나가야 하는데 그러지 못한 경우라면 slow를 한 칸 더 이동시켜준다.
- slow의 나머지 이동 경로와 역순으로 만든 rev의 노드를 하나씩 풀어나가며 비교한다.

---

# 두 정렬 리스트의 병합

[Merge Two Sorted Lists - LeetCode](https://leetcode.com/problems/merge-two-sorted-lists/)

## Problem

정렬되어 있는 두 연결 리스트를 합치는 문제

### ISSUE

- 정렬된 리스트가 주어졌고, 새로 합친 리스트도 해당 정렬이 유지되어야 한다.

## Solution

### 1. 재귀 구조로 연결

병합 정렬에서 첫 번째 값부터 차례대로 비교하듯이 정렬된 리스트라는 전제가 있으므로 첫 번째부터 비교하면서 리턴하는 방식으로 풀이할 수 있다. 

두 리스트의 값에 대해 비교 연산을 먼저 수행하고 더 작은 것을 왼쪽에 위치하도록 스왑한다. 더이상 비교가 불가능한 경우, 즉 어느 한 리스트가 맨 끝에 다다른 경우는 다른 한 리스트의 원소를 그대로 넣어준다. (이미 정렬되어 있기 때문)

***변수 스왑(Swap)**

> 임시 변수(temp)를 사용하기!
> 

파이썬에서는 a,b = b,a와 같은 코드로 간단하게 구현할 수 있다. 

---

# 역순 연결 리스트

[Reverse Linked List - LeetCode](https://leetcode.com/problems/reverse-linked-list/)

## Problem

연결 리스트를 뒤집는 문제

### ISSUE

- 다음 노드를 이전 노드로 연결하면 역순이 된다.

## Solution

### 1. 재귀 구조로 뒤집기

다음 노드와 현재 노드를 파라미터로 하는 reverse 함수를 정의하고, 노드가 맨 마지막에 다다를 때까지 재귀 호출한다. 마지막에 이 재귀 호출에 의해 백트래킹되며 연결 리스트가 거꾸로 연결된다. 

### 2. 반복 구조로 뒤집기

node.next를 이전 prev 리스트로 계속 연결하면서 마지막에 다다를 때까지 (=while문 종료 전) 

---

# 두 수의 덧셈

[Add Two Numbers - LeetCode](https://leetcode.com/problems/add-two-numbers/)

## Problem

역순으로 저장된 연결 리스트의 숫자를 더하는 문제

### ISSUE

- 2→4→3 : 342   / 5→6→4 : 465 로 읽어 이 두 수를 더한 값을 결과로 출력한다.
- 앞의 자리부터 0으로 초기화한 변수에 저장하고 다음 노드로 넘어갈 때마다 10씩 곱한 다음에 새로운 수를 더해나간다. (자릿수의 특징을 이용)
- 풀이
    
    ```python
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
            num1, num2 = 0, 0
    
            while l1:
                num1 += l1.val + (num1 * 10)
                l1 = l1.next
            while l2:
                num2 += l2.val + (num2 * 10)
                l2 = l2.next
    
            sum = num1 + num2
            while sum > 0:
                c = ListNode(sum % 10)
                c = c.next
                sum /= 10
            return c
    ```
    
    하나의 함수에서 연결 리스트의 데이터만을 읽어 숫자로 변환한 후, 각 숫자들을 더한 값으로 연결 리스트를 만들고자 했으나 점점 코드에 대한 가독성과 이해가 떨어져 연결 리스트의 특성에 따른 head, next, val 등의 변수명을 통일해야 한다는 필요성을 느꼈다. 
    

## Solution

### 1. 자료형 변환

연결 리스트 → 문자열로 이어 붙이기 → 숫자로 변환 → 계산 후 다시 연결 리스트로 

→ 하나의 함수 말고 여러 개의 함수를 정의하여 풀이하는 것이 훨씬 효율적

- 연결 리스트 뒤집기
    
    ```python
    def reversedList(self, head:ListNode) -> ListNode:   # 연결 리스트 뒤집기
            node, prev = head, None
    
            while node:
                next, node.next = node.next, prev
                prev, node = node, next
            return prev
    ```
    
- 연결 리스트 → 파이썬 리스트 변환
    
    ```python
    def toList(self, node: ListNode) -> List:    # 연결리스트 -> 파이싼 리스트 변환
            list: List = []
            while node:
                list.append(node.val)
                node = node.next
            return list
    ```
    
- 파이썬 리스트 → 연결 리스트 변환
    
    ```python
    def toReversedLinkedList(self, result: str) -> ListNode:   # 파이썬 리스트 -> 연결 리스트 변환
            prev: ListNode = None
            for r in result:
                node = ListNode(r)
                node.next = prev
                prev = node
    
            return node
    ```
    
- `int(''.join(*str*(e) *for* e *in* a))`  숫자형 리스트를 단일 정수값으로 병합하는 코드
    
    ⇒ 이는 `int(’’.join(map(str, a))` 와 같은 코드로도 구현할 수 있다.
    
    ⇒ 람다 표현식을 이용하면 `functools.reduce(lambda x, y: 10*x + y, a, 0)` 의 코드로 구현할 수 있다. 
    
    **functool이란*
    함수를 다루는 함수인 ‘고계함수’를 지원하는 함수형 언어 모듈 → 리트코드에 기본적으로 import 되어 있음
    
    위에서 쓰인 reduce()는 두 인수의 함수를 누적 적용하라는 기능의 메소드이다. 
    

### 2. 전가산기 구현

논리 회로의 전가산기란? 십진법으로 자리 올림수까지 구하는 원리로 계산해나가는 것 → A, B, CarryIn, Sum, CarryOut의 개념이 여기서 등장한 것이다 

입력값에 대한 합을 먼저 구하고, 자릿수가 넘어가는 경우에 자리 올림수를 설정하여 계산한다. 이는 이전의 자리올림수인 carry를 받아오고 이를 divmod()로 계산하는 방식이며, 그 다음의 연산에도 사용될 수 있다는 특징을 가진다. 

ex. (2→4→3) + (5→6→4) ⇒ 3 + 4 = (0, 7) / 4 + 6 = (1, 0) / 2 + 5 = (0+***1*** , 7)
---

# 페어의 노드 스왑

[Swap Nodes in Pairs - LeetCode](https://leetcode.com/problems/swap-nodes-in-pairs/)

## Problem

연결 리스트를 입력받아 페어 단위로 스왑하는 문제

### ISSUE

- 앞에서 두 개씩 묶어서 스왑한다.
- 연결리스트이므로 노드 자체를 스왑하는 방법과 값만 바꿔치기 하는 방식 모두 구현할 수 있다.
- 풀이
    
    ```python
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = head
        while cur and cur.next:
            temp = cur.val
            cur.val = cur.next.val
            cur.next.val = temp
    
            cur = cur.next.next
    
        return head
    ```
    

## Solution

### 1. 값만 교환

연결 리스트의 노드를 변경하는 것이 아닌, 노드 구조는 그대로 유지하되 값만 변경하는 방법

### 2. 반복 구조로 스왑

노드 자체를 변경하려면 이전 노드와 다음 노드에 연결된 현재 노드를 다루는 것이므로, 임시 노드를 거쳐서 스왑시켜야 한다. 아래와 같이 b라는 임시 노드에 할당 후 안전하게 스왑할 수 있다. 

```python
b = a.next
a.next = b.next
b.next = b
```

하지만, 이밖에 고려해야 할 점은 이전 노드와의 연결이 끊어졌다는 것이다. 따라서 아래와 같이 이전 노드와 연결하는 부분이 필요하다.

```python
prev.next = b   # 이전 노드와 연결하기
```

다음 페어를 스왑하기 위해 전진한다. 

```python
a = a.next 
prev = prev.next.next
```

반복 구조의 풀이는 리스트의 현재 노드와 스왑할 노드 각각 가리키는 포인터가 필요하므로, 총 두 개의 포인터를 필요로 한다. 이를 조금 더 간단하게 구현하려면 재귀 구조로 풀이하는 방법이 있다.

### 3. 재귀 구조로 스왑

재귀 구조는 하나의 포인터만을 필요로 하며, 더미 노드를 만들 필요 없이 head를 바로 리턴한다. 재귀 호출로 스왑된 값을 바로 리턴받으며 백트래킹되면서 연결 리스트가 끊기지 않고 연결될 수 있다. 

```python
def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head and head.next:
            p = head.next   # 포인터 역할

            # 스왑된 값을 리턴받음
            head.next = self.swapPairs3(p.next)
            p.next = head
            return p    
        return head
```

---

# 홀짝 연결 리스트

[Odd Even Linked List - LeetCode](https://leetcode.com/problems/odd-even-linked-list/)

## Problem

연결 리스트를 홀수 노드 다음에 짝수 노드가 오도록 재구성하는 문제 

조건 - *공간 복잡도 O(1), 시간 복잡도 O(n)에 풀이하라*

### ISSUE

- 한 번의 루프로 해결할 수 있어야 한다.
- 리스트의 총 길이를 먼저 알고, 홀짝 각 개수를 파악한다.
- 홀수는 `head`부터, 짝수는 `head.next` 부터 시작한다.
    - 이들은 각각 두 칸씩 이동한다.
- 제약 조건이 없었다면 연결 리스트를 파이썬의 리스트 형태로 변환해서 파이썬 슬라이싱, 내장 함수 등으로 쉽게 풀이할 수 있다.

## Solution

### 1. 반복 구조로 홀짝 노드 처리

홀수의 헤더를 odd로, 짝수의 헤더를 even_head로 하고 리스트를 순회하는 포인터는 even으로 설정한다. 

```python
while even and even.next:
    odd.next = odd.next.next
    odd = odd.next
    even.next = even.next.next
    even = even.next
```

위와 같은 반복 구조로 리스트를 순회하게 되는데, 이를 파이썬 스타일로 다중 할당 처리하면 가능한 경우는 홀수와 짝수를 동시에 움직이는 것 뿐이다. 즉, 위 코드에서 1~2 / 3~4 를 묶는 것은 불가능하고, 1,3 / 2,4 로만 묶을 수 있다는 것이다. 가능한 이유는 홀수 번째 노드와 짝수 번째 노드를 처음부터 각각의 포인터로 순회하고 독립적으로 동작하기 때문이다. 

여기서 홀수 다음에 짝수가 오도록 하는 중요한 부분은 **홀수 노드의 마지막을 짝수의 헤드로 연결하는 것이다.** 

```python
odd.next = even_head   # 짝수의 헤드를 반복문을 돌기 전에 미리 저장해둔다. 
```

---

# 역순 연결 리스트 II

[Reverse Linked List II - LeetCode](https://leetcode.com/problems/reverse-linked-list-ii/)

## Problem

주어진 인덱스 m~n까지 역순으로 만드는 문제  *인덱스 m은 1부터 시작

### ISSUE

- 이전 풀이와 같이 재귀 구조와 반복 구조로 풀이하는 방식 모두 존재한다.
- 리스트를 순회하는 포인터의 시작을 head에서 m만큼 이동한 후에, 이전 역순 리스트 풀이와 동일하게 풀이하면 된다.
- 해당 인덱스 범위의 리스트를 따로 만들어서 역순으로 뒤집은 뒤에 다시 붙이는 방법도 고려해볼 수 있다.

- 풀이
    
    ```python
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = head
        while cur and cur.next:
            temp = cur.val
            cur.val = cur.next.val
            cur.next.val = temp
    
            cur = cur.next.next
    
        return head
    ```
    

## Solution

### 1. 반복 구조로 노드 뒤집기

리스트의 시작(start)과 끝(end)을 각각 시작 인덱스-1, 시작 인덱스로 고정 시켜두고, head 보다 이전에 위치한 root를 할당하여 결과값은 root.next로 반환한다. 따라서 위 예제 상으로 start가 2일 때, start와 end는 각각 1과 2로 마지막까지 유지되며 이를 기준으로 리스트를 역순으로 뒤집는다. 

```python
# start와 next는 고정
for _ in range(left - 1):
    start = start.next
end = start.next
```

`시작 인덱스-1` 의 노드를 start로 두고, 그 다음 `시작 인덱스` 의 노드를 end로 둔다. 

```python
# start(시작 인덱스 직전)와 end(시작 인덱스) 범위에서의 리스트 뒤집기 반복
for _ in range(right - left):
    tmp, start.next, end.next = start.next, end.next, end.next.next
    start.next.next = tmp
return root.next
```

더미 노드를 이용해서 범위 내의 노드들을 뒤집는 코드이다.