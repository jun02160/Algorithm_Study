#LeetCode 문제. https://leetcode.com/problems/two-sum/
from typing import List


class Solution:
    # 1. 브루트 포스로 계산 => 나의 풀이
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        result = []
        for i in range(0, len(nums)):
            for j in range(i+1, len(nums)):
                if (nums[i] + nums[j] == target):
                    result.append(i)
                    result.append(j)
                    break

        return result

    # 2. in을 이용한 탐색
    def twoSum2(self, nums: List[int], target: int) -> List[int]:
        for i, n in enumerate(nums):
            complement = target - n

            if complement in nums[i+1:]:
                return [nums.index(n), nums[i+1:].index(complement) + (i+1)]

    # 3. 첫 번째 수를 뺀 결과 키 조회
    def twoSum3(self, nums: List[int], target: int) -> List[int]:
        nums_map = {}

        # 키와 값을 바꿔서 딕셔너리로 저장
        for i, num in enumerate(nums):
            nums_map[num] = i

        # 타겟에서 첫 번째 수를 뺀 결과로 키 조회
        for i, num in enumerate(nums):
            if target - num in nums_map and i != nums_map[target - num]:  # 두 번째 수를 키로 가진 값이 딕셔너리 내에 존재하고, 자기 자신이 아니면 결과 존재!
                return [i, nums_map[target-num]]


    # 4. 조회 구조 개선
    def twoSum4(self, nums: List[int], target: int) -> List[int]:
        nums_map = {}
        # 위 3번에서 하나의 for문으로 통합
        for i, num in enumerate(nums):
            if target - num in nums_map:
                return [nums_map[target - num], i]
            nums_map[num] = i

    # 5. 투 포인터 이용
    def twoSum5(self, nums: List[int], target: int) -> List[int]:
        nums.sort()

        left, right = 0, len(nums)-1
        while not left == right:
            # 합이 타깃보다 작으면 왼쪽 포인터를 오른쪽으로 이동
            if nums[left] + nums[right] < target:
                left += 1
            # 합이 타깃보다 크면 오른쪽 포인터를 왼쪽으로 이동
            elif nums[left] + nums[right] > target:
                right -= 1
            else:
                return [left, right]

