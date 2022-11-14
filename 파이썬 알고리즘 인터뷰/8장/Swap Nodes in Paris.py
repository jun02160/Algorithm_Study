# Definition for singly-linked list.
from typing import Optional, List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def printList(self, link: Optional[ListNode]) -> List[int]:
        result = []
        cur = link
        while link:
            result.append(link.val)
            link = link.next
        return result

    ## 값만 교환하는 방식
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = head
        while cur and cur.next:
            temp = cur.val
            cur.val = cur.next.val
            cur.next.val = temp
            
            # -> cur.val, cur.next.val = cur.next.val, cur.val 로 간단히 작성 가능

            cur = cur.next.next

        result = self.printList(head)
        print(result)


    ## 반복 구조로 스왑
    def swapPairs2(self, head: Optional[ListNode]) -> Optional[ListNode]:
        root = prev = ListNode(None)   # 빈 노드 생성
        prev.next = head

        while head and head.next:
            # b가 a(head)를 가리키도록 할당
            b = head.next   # b는 현재 노드의 다음 노드를 가리킴 (한 페어의 시작 그 다음과 바꾸기 위함)
            head.next = b.next
            b.next = head

            # prev가 b를 가리키도록 할당
            prev.next = b

            # 다음 비교를 위해 이동
            head = head.next
            prev = prev.next.next

    ## 재귀 구조로 스왑
    def swapPairs3(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head and head.next:
            p = head.next   # 포인터 역할

            # 스왑된 값을 리턴받음
            head.next = self.swapPairs3(p.next)
            p.next = head
            return p    
        return head
            