# LeetCode 문제. https://leetcode.com/problems/3sum/
# 배열을 입력받아 합이 0이 되는 3개의 엘리먼트를 출력하는 문제
from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        for i in range(0, len(nums)):
            num = []
            for j in range(i, i+3):
                if (j < len(nums)):
                    num.append(nums[j])
            if self.getSum(num) == 0 and len(num) == 3:
                result.append(num)

        return result

    def getSum(self, num: List[int]):
        sum = 0
        for i in num:
            sum += i
        return sum

result = Solution()
print(result.threeSum([-1, 0, 1, 2]))