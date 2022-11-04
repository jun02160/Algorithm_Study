# LeetCode 문제. https://leetcode.com/problems/3sum/
# 배열을 입력받아 합이 0이 되는 3개의 엘리먼트를 출력하는 문제
from typing import List
import itertools

# 조합을 이용한 풀이
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()

        comb = list(itertools.combinations(nums, 3))
        for n in comb:
            num = list(n)
            if self.getSum(num) == 0 and len(num) == 3:
                result.append(num)

        return result

    def getSum(self, num: List[int]):
        sum = 0
        for i in num:
            sum += i
        return sum

    ##### 교재 풀이 ######
    # 1. 브루트 포스로 계산
    def threeSumB(self, nums: List[int]) -> List[List[int]]:
        results = []
        nums.sort()

        # 브루트 포스 n^3 반복
        for i in range(len(nums)-2):
            if i > 0 and nums[i] == nums[i-1]:   # 중복된 값 건너뛰기 (IndexError 방지를 위해 인덱스가 0일 때는 제외)
                continue
            for j in range(i+1, len(nums)-1):
                if j > i+1 and nums[j] == nums[j-1]:
                    continue
                for k in range(j+1, len(nums)):
                    if k > j+1 and nums[k] == nums[k-1]:
                        continue

                    if nums[i] + nums[j] + nums[k] == 0:
                        results.append([nums[i], nums[j], nums[k]])

        return results

    # 2. 투 포인터로 구하기
    def threeSumTwo(self, nums: List[int]) -> List[List[int]]:
        results = []
        nums.sort()

        for i in range(len(nums) - 2):
            # 중복된 값 건너뛰기
            if i > 0 and nums[i] == nums[i-1]:
                continue

            # 간격을 좁혀나가며 합 sum 계산
            left, right = i+1, len(nums)-1
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                if sum < 0:   # 합이 음수이므로 0을 만들기 위한 양수 필요
                    left += 1
                elif sum > 0:   # 합이 양수이므로 0을 만들기 위한 음수 필요
                    right -= 1
                else:
                    results.append([nums[i], nums[left], nums[right]])

                    while left < right and nums[left] == nums[left+1]:
                        left += 1
                    while left < right and nums[right] == nums[right-1]:
                        right -= 1

                    left += 1
                    right -= 1

        return results


result = Solution()
print(result.threeSumB([-1, 0, 1, 2, -1, -4]))
print(result.threeSumTwo([-1, 0, 1, 2, -1, -4]))