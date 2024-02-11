class Solution {
    public boolean isPalindrome(String s) {
        String filteredStr = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reverseStr = new StringBuilder(filteredStr).reverse().toString();
        
        return filteredStr.equals(reverseStr);
    }
}