class Solution {
    public String[] reorderLogFiles(String[] logs) {
        /**
        type1. 식별자+문자 로그(사전순)  type2. 식별자+숫자 로그(입력순)
        -> 각각의 리스트를 나누어 저장
        
        정렬조건이 존재하는 문자 리스트를 분리하여 정렬 후, 뒤에 숫자 리스트 그대로 이어붙이기
        WHY? ASCII 상으로 숫자가 앞이라 입력값 그대로는 컬렉션의 sort() 사용 불가
        */
        
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        
        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }
        
        // 문자 리스트 정렬
        letters.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);  // 식별자를 기준으로 2개 부분으로 분할
            String[] s2x = s2.split(" ", 2);
            
            // 식별자 뒷부분부터 사전순으로 비교
            int compared = s1x[1].compareTo(s2x[1]);
            if (compared == 0) {  // 동일한 경우, 식별자끼리 비교
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });
        
        letters.addAll(digits);
        return letters.toArray(new String[0]);
        
        
    }
}