# Leetcode 문제. https://leetcode.com/problems/palindrome-linked-list/
# Definition for singly-linked list.
import collections
from typing import Optional, List, Deque


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    # 1. 파이썬 리스트로 변환
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        q: List = []

        if not head:
            return True

        node = head
        #리스트 변환
        while node is not None:
            q.append(node.val)
            node = node.next  # 노드 순회
            
        # 팰린드롬 판별
        while len(q) > 1:
            if q.pop(0) != q.pop():   # 맨 앞 요소와 마지막 요소가 같은지만을 검사 (pop으로 삭제와 반환 동시에 한다는 특성 이용)
                return False
        return True

    # 2. 데크를 이용해 1번의 풀이를 최적화
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        q: Deque = collections.deque()

        if not head:
            return True

        node = head
        # 리스트 변환
        while node is not None:
            q.append(node.val)
            node = node.next  # 노드 순회

        # 팰린드롬 판별
        while len(q) > 1:
            if q.popleft() != q.pop():  # 맨 앞 요소와 마지막 요소가 같은지만을 검사 (pop으로 삭제와 반환 동시에 한다는 특성 이용)
                return False
        return True
    
    # 3. 런너를 이용한 풀이
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        rev = None   # slow의 역순 연결 리스트가 저장됨 2->1->None
        slow = fast = head
        
        # 런너를 이용해 역순 연결 리스트 구성
        while fast and fast.next:  # 빠른 런너의 다음 노드가 존재하면
            fast = fast.next.next
            rev, rev.next, slow = slow, rev, slow.next   # 역순으로 구성하기 위함
        if fast:   # fast가 아직 끝에 다다르지 않은 경우 slow 전진
            slow = slow.next

        # 팰린드롬 여부 확인
        while rev and rev.val == slow.val:
            slow, rev = slow.next, rev.next
        return not rev
        