def isPalindrome(s: str) -> bool:
    s = s.lower()
    str_list = []
    for c in s:
        if c.isalnum():
            str_list.append(c)
    for i in range(len(str_list)):
        print(str_list[i])
        print(str_list[len(str_list) - i - 1])
        if str_list[i] != str_list[len(str_list) - i - 1]:
            return False;
    return True;

result = isPalindrome("A man, a plan, a canal: Panama")
print(result)