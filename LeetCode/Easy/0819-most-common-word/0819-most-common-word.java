class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");  // Data Cleansing
        
        // 단어별 빈도 수를 키-값 형태로 저장
        Map<String, Integer> counts = new HashMap<>();
        // 금지어 목록 -> Set (Collection 기능을 사용하기 위함)
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        
        for (String word : words) {
            if (!ban.contains(word)) {  // 금지어에 포함되지 않는 경우
                counts.put(word, counts.getOrDefault(word, 0)+1);
            }
        }
        
        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}