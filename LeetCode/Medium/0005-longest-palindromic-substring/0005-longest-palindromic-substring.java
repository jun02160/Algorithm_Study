class Solution {
    
    int left, maxLen;  // 최장 팰린드롬 문자열의 길이
    
    public String longestPalindrome(String str) {
        
        /**
        투 포인터 - 중앙을 중심으로 확장해나가며 가장 긴 팰린드롬을 판별하도록 구현
        -> 팰린드롬을 발견하면? 오른쪽 방향으로 확장
        */
        int len = str.length();
        
        if (len < 2) return str;  // 예외처리
        
        // 오른쪽 방향으로 투포인터 검사
        for (int i=0; i<len-1; i++) {
            extendPalindrome(str, i, i+1);  // 2칸
            extendPalindrome(str, i, i+2);  // 3칸
        }
        
        return str.substring(left, left+maxLen);
    }
    
    public void extendPalindrome(String str, int l, int r) {
        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--;  // 왼쪽으로 확장
            r++;  // 오른쪽으로 확장
        }

        if (maxLen < r-l-1) {  // 확장상태에서 while을 빠져나왔으니 고려하여 길이 구하기
            left = l+1;  // -1 해준 값에서 원상복구
            maxLen = r-l-1;
        }
    }
}