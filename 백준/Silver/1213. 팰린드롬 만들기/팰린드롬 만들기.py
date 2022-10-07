# 대문자로 이루어진 영문 이름을 입력받아 알파벳 순서를 적절히 바꾸고, 팰린드롬을 만드는 코드

def isSame(arr):
    alpha_cnt = {}   # 딕셔너리에 각 알파벳 개수를 저장
    for word in arr:
        try:    # KeyError 방지를 위한 try-catch 구문
            alpha_cnt[word] += 1
        except KeyError:
            alpha_cnt[word] = 1

    return alpha_cnt

# 홀수 개수는 0 또는 1이어야 함
def isOddCnt(dic):
    cnt = 0   # 홀수 개수 저장
    for i in dic.values():
        if i % 2 != 0:
            cnt += 1

    if cnt > 1:
        return True
    else:
        return False
    

name_list = list(input())   # 입력과 동시에 문자열->리스트로 변환
name_list.sort()   # 알파벳 순으로 정렬 (대칭 순서가 절반을 나누었을 때, 알파벳 순)

palindrome = []
name_cnt = isSame(name_list)
keys = list(name_cnt.keys())
vals = list(name_cnt.values())

if not isOddCnt(name_cnt):
    for i in range(len(name_cnt)):
        for j in range(vals[i] // 2):    # 절반만큼 잘라서 데칼코마니로 보기
            palindrome.append(keys[i])

    # 알파벳이 모두 짝수개인 경우 (= 홀수개인 알파벳 없음)
    if len(name_list) % 2 == 0:
        palindrome = ''.join(palindrome)
        re_palindrome = ''.join(reversed(palindrome))
        print(palindrome+re_palindrome)   # 절반을 기준으로 나눠서 문자열을 만들고 이어붙인다.


    # 홀수인 알파벳이 하나 존재하는 경우
    else:
        for i in range(len(name_cnt)):
            if vals[i] % 2 != 0:
                odd = [key for key, value in name_cnt.items() if value == vals[i]]

        palindrome = ''.join(palindrome)
        re_palindrome = ''.join(reversed(palindrome))
        odd = ''.join(odd)
        print(palindrome+odd+re_palindrome)   # 가운데에 홀수개인 알파벳이 들어가고 나머지는 짝수인 경우와 동일하다.

else:
    print("I'm Sorry Hansoo")