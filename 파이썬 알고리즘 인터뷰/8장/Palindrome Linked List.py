# Leetcode 문제. https://leetcode.com/problems/palindrome-linked-list/
# Definition for singly-linked list.

from typing import Optional, List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        q: List = []

        if not head:
            return True

        node = head
        #리스트 변환
        while node is not None:
            q.append(node.val)
            node = node.next