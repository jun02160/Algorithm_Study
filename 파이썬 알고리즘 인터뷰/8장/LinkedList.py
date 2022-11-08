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
