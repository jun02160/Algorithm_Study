def solution(num):
    
    if num == 1:
        return 0
    
    cnt = 0    # 루프의 반복 횟수 카운트
    
    while (num != 1):
        if num % 2 == 0:
            num /= 2
        else:
            num *= 3
            num += 1
        cnt += 1
        
        if cnt >= 500:
            return -1
        
    return cnt