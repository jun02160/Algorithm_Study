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

    def productExceptSelfR(self, nums: List[int]) -> List[int]:
        out = []
        p = 1
        # 왼쪽 곱셈
        for i in range(0, len(nums)):
            out.append(p)
            # print("p = %d" % p)
            p *= nums[i]
            # print("p *nums[i] = %d" % p)
        p = 1
        # print(out)
        # 왼쪽 곱셈 결과에 오른쪽 값을 차례로 곱셈
        for i in range(len(nums) - 1, 0 - 1, -1):
            out[i] *= p
            p *= nums[i]
        return out

a = Solution()
print(a.productExceptSelfR([-1,1,0,-3,3]))
print(a.productExceptSelfR([1,2,3,4]))
