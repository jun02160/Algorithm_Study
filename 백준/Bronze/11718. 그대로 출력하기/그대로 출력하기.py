while True:
    try:
        print(input())
    except EOFError:   # 출력이 완료되고 아무것도 입력되지 않았을 때 루프 탈출
        break
        