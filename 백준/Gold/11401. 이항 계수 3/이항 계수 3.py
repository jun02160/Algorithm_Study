p = 1000000007

# 팩토리얼
def factorial(n):
    # print('!')
    result = 1 
    for i in range(2, n+1):
        result = (result*i) % p
    return result

# 거듭제곱
def power(x, n):
    if n == 0:
        return 1
    elif n % 2 == 0:
        return (power(x, n//2) ** 2) % p
    else:
        return (power(x, n//2) ** 2 * x) % p

n, k = map(int, input().split())


# 페르마의 소정리를 이용한 조합 풀이
top = factorial(n)
bottom = factorial(n-k) * factorial(k) % p
print(top*power(bottom, p-2) % p)


