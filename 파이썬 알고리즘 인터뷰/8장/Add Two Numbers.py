# Leetcode 문제. https://leetcode.com/problems/add-two-numbers/
from typing import Optional, List


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
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

    #1. 자료형 변환
    def reversedList(self, head:ListNode) -> ListNode:   # 연결 리스트 뒤집기
        node, prev = head, None

        while node:
            next, node.next = node.next, prev
            prev, node = node, next
        return prev

    def toList(self, node: ListNode) -> List:    # 연결리스트 -> 파이싼 리스트 변환
        list: List = []
        while node:
            list.append(node.val)
            node = node.next
        return list

    def toReversedLinkedList(self, result: str) -> ListNode:   # 파이썬 리스트 -> 연결 리스트 변환
        prev: ListNode = None
        for r in result:
            node = ListNode(r)
            node.next = prev
            prev = node

        return node
    def addTwoNumbers2(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        a = self.toList(self.reversedList(l1))
        b = self.toList(self.reversedList(l2))

        resultStr = int(''.join(str(e) for e in a)) + \
            int(''.join(str(e) for e in b))

        return self.toReversedLinkedList(str(resultStr))

    # 3.
    def addTwoNumbers3(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        root = head = ListNode(0)

        carry = 0
        while l1 or l2 or carry:
            sum = 0
            # 두 입력값의 합을 계산
            if l1:
                sum += l1.val
                l1 = l1.next
            if l2:
                sum += l2.val
                l2 = l2.next

            # 몫(자리올림수)과 나머지(값) 계산
            carry, val = divmod(sum+carry, 10)
            head.next = ListNode(val)
            head = head.next

        return root.next