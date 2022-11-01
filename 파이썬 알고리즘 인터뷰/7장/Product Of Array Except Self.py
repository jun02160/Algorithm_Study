# leetcode 문제. https://leetcode.com/problems/product-of-array-except-self/
# 자신을 제외한 나머지 모든 요소의 곱셈 결과를 출력하는 문제
from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = []
        mul = 1
        for j in range(0, len(nums)):
            for i in range(0, len(nums)):
                if i != j:
                    mul *= nums[i]
            result.append(mul)
            mul = 1
        return result

a = Solution()
print(a.productExceptSelf([-1,1,0,-3,3]))
