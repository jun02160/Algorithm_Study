# leetcode 문제. https://leetcode.com/problems/Best-Time-To-Buy-and-Sell-Stock/
# 한 번의 거래로 낼 수 있는 최대 이익을 산출하는 문제
import sys
from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> int:
        min_num = min(nums)
        max_num = max(nums)

        if nums.index(min_num) < nums.index(max_num):
            return max_num - min_num
        else:
            max_num = 0
            for i in range(nums.index(min_num), len(nums)):
                if max_num < nums[i]:
                    max_num = nums[i]
            return max_num - min_num

    # 1. 브루트 포스로 계산
    def productExceptSelfB(self, prices: List[int]) -> int:
        max_price = 0

        for i, price in enumerate(prices):
            for j in range(i, len(prices)):
                max_price = max(prices[j] - price, max_price)
        return max_price

    # 2. 저점과 현재 값과의 차이 계산
    def productExceptSelfB(self, prices: List[int]) -> int:
        profit = 0   # 최대 이익
        min_price = sys.maxsize

        # 최댓값과 최솟값의 갱신
        for price in prices:
            min_price = min(min_price, price)
            profit = max(profit, price - min_price)

        return profit



a = Solution()
print(a.productExceptSelfB([7,1,5,3,6,4]))
