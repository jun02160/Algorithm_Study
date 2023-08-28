def knapSack(W, wt, val, n):
    A = [[0 for x in range(W+1)] for x in range(n+1)]
		
    for i in range(1, n+1):
        for w in range(1, W+1):
            if wt[i-1] > w:
                A[i][w] = A[i-1][w]
            else:
                valWith = val[i-1] + A[i-1][w-wt[i-1]] # 1. 물건을 넣지 않았을 때
                valWithout = A[i-1][w]  # 2. 물건을 넣었을 때 (내 물건의 무게만큼 떼고 난 가치 + 내 물건의 가치) 
                A[i][w] = max(valWith, valWithout)  # 둘 중 더 큰 것이 최대 가치

    return A[n][W]    

N, W = map(int, input().split())
val = []
wt = []

for i in range(N):
    a, b = map(int, input().split())
    wt.append(a)
    val.append(b)
    
print(knapSack(W, wt, val, N))
