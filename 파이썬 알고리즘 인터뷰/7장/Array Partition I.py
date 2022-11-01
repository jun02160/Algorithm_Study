# 2*n 개의 배열에서 n개의 쌍을 만든 후 쌍의 최솟값의 합이 최대가 되는 값을 반환하는 문제
from typing import List

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()
        temp = []
        sum = 0
        for num in nums:
            temp.append(num)

            if len(temp) == 2:
                sum += min(temp)
                temp = []

        return sum

a = Solution()
print(a.arrayPairSum([1,3,2,4]))
