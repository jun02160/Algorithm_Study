def solution(num_list):
    ## list 오름차순 정렬
    ## 내장함수: 리스트이름.sort() / sorted(리스트)
    num_list = sorted(num_list)
    answer = num_list[:5]  # 5개까지만 -> 슬라이싱 기법 활용  (인덱스를 사용해서 1가지 이상의 원소를 가져오는 역할) [시작위치:끝위치+1]
    return answer