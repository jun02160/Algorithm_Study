# Leetcode 문제. https://leetcode.com/problems/merge-two-sorted-lists/
from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    ## 1. 재귀 구조로 연결
    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if (not l1) or (l2 and l1.val > l2.val):
            l1, l2 = l2, l1    # l1의 값과 l2의 값을 비교하고 더 작은 값이 앞쪽에 오도록 -> SWAP
        if l1:
            l1.next = self.mergeTwoLists(l1.next, l2)
        return l1