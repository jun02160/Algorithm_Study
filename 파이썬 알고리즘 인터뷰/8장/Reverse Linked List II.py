from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        # 예외 처리
        if not head or left == right:
            return head

        root = start = ListNode(None)
        root.next = head

        # start와 next는 고정
        for _ in range(left - 1):
            start = start.next
        end = start.next

        # start(시작 인덱스 직전)와 end(시작 인덱스) 범위에서의 리스트 뒤집기 반복
        for _ in range(right - left):
            tmp, start.next, end.next = start.next, end.next, end.next.next
            start.next.next = tmp
        return root.next