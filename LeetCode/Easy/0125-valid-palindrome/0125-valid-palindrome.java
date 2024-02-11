class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        
        // char 원시형으로 비교하는 방법이 문자열의 동등성을 비교하는 방법보다 빠름!
        while (start <= end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        
        return true;
    }
}