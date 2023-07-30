from itertools import combinations   # 조합에 관한 라이브러리 이용 

N, S = map(int,input().split())
num = list(map(int,input().split()))
cnt = 0     # 부분수열의 개수 세기

for i in range(1, len(num)+1):   # 조합 개수의 경우의 수는 1~num의 길이
    arr = list(combinations(num, i))
    for j in arr:
        if sum(j) == S:
            cnt += 1

print(cnt)
