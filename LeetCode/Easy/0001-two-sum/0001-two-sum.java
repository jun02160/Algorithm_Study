class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        /*
        sol1. 브루트 포스 풀이
        int[] result = new int[2];

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j]+nums[i] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
        */
        
        
        // sol2. 해시테이블의 빠른 속도를 이용해 조회 시간 단축
        Map<Integer, Integer> numsMap = new HashMap<>();  
        
        //for (int i=0; i<nums.length; i++) {
        //    numsMap.put(nums[i], i);  // 인덱스(키)와 값을 바꿔서 저장
        //} 
        
        for (int i=0; i<nums.length; i++) {
            if (numsMap.containsKey(target-nums[i])) {
                return new int[]{numsMap.get(target-nums[i]), i};  // 인덱스가 작은 값부터 리턴
            }
            numsMap.put(nums[i], i);  // 정답이 아니면 비교를 위해 Map에 추가
        }
        return null;
        
        
        /*
        sol3. 투 포인터 이용 - index만 이용하므로 별도의 배열 정렬 로직 필요X
        int left = 0;
        int right = nums.length-1;
        
        while (left != right) {
            if (nums[left] + nums[right] < target) {
                left += 1;
            } else if (nums[left] + nums[right] > target) {
                right -= 1;
            } else {
                return new int[]{left, right};
            }
        }
        return null;
        */

    }
}