## 연결 리스트를 이용한 스택의 ADT 구현
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


stack = Stack()
stack.push(1)
stack.push(2)
# printStack(stack)
stack.pop()
print(stack.last)
# printStack(stack)