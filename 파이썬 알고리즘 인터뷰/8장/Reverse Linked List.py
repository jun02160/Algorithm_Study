# Leetcode 문제. https://leetcode.com/problems/reverse-linked-list/
# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    # 1. 재귀 구조로 뒤집기
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def reverse(node:ListNode, prev:ListNode = None):
            if not node:
                return prev;
            next, node.next = node.next, prev
            return reverse(next, node)
        return reverse(head)

    # 2. 반복 구조로 뒤집기
    def reverseList2(self, head: Optional[ListNode]) -> Optional[ListNode]:
        node, prev = head, None

        while node:
            next, node.next = node.next, prev
            prev, node = node, next
        return prev

