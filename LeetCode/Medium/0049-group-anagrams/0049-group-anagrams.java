class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // Anagram의 특징: 정렬하면 같은 값이 된다! => 키 값으로 이용
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();  // String -> char[]
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            } 
            result.get(key).add(str);
        }
        
        return new ArrayList<>(result.values()); // Map<List<String>> -> List<List<String>>
    }
}