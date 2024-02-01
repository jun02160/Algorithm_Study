T = int(input())

for i in range(T):
    data = str(input())
    if data.count('(') == data.count(')'):
        while '()' in data:
            data = data.replace('()', '')
        if len(data) == 0: print('YES')
        else: print('NO')
    else: print('NO')