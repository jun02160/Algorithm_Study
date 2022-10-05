# 펠린드롬(Palindrome)

앞뒤가 똑같은 단어나 문장으로, 뒤집어도 같은 말이 되는 단어 또는 문장 ( = 회문)

## Problem

주어진 문자열이 펠린드롬인지 확인하라. 대소문자를 구분하지 않으며, 영문자와 숫자만을 대상으로 한다.

### ISSUE

- 문자열에 대한 펠린드롬 여부를 확인하는 것이므로, 다른 특수기호는 제외한다.
    
    → 문자열에서 각 문자 또는 숫자로 분리해야 한다. (공백 무시)
    
- 대소문자를 구분하지 않는다.
    
    → lower() 이나 upper() 함수를 사용하여 영문자를 하나로 통일시킨다. 
    

## Solution

### 1. 리스트로 변환

문자열에 대해 반복문을 돌며 isalnum() 함수로 숫자 또는 영문자인지 판별 후, 리스트에 추가하는 방법

→ pop()으로 첫 번째 원소와 마지막 원소를 리턴하면서 두 값이 일치하는지 비교한다. 

### 2. 데크 자료형을 이용한 최적화

 리스트보다 속도 UP - 리스트에서의 pop(0)은 O(n)이지만, 데크의 popleft()는 O(1)에 수행가능하다. 이를 n번씩 수행하므로 각 n배를 더하면 더욱 큰 성능 차이가 난다. 

### 3. 슬라이싱 사용

정규식을 이용해 불필요한 문자를 필터링한다. 즉, 문자열 안에서 불필요한 문자를 ‘’로 바꾸어 걸러내기 때문에 추가적인 자료구조는 필요하지 않고, 문자열 자체에서 [::-1]로 마지막 원소부터 비교가 가능해진다. 

파이썬에서 슬라이싱을 사용하는 방법도 별도 자료형을 매핑하는 과정보다 훨씬 시간을 단축할 수 있다. 

### 4. C 구현

숫자, 영문자가 아닌 필터링이 필요한 문자는 bias_left, bias_right 변수를 이용해 그 위치를 건너뛰기 한다. 즉, 위치 포인터의 관점에서 주소만 참조하면 되므로 매우 빠르게 실행된다. 

팰린드롬 비교 → `if(tolower(s[i + bias_left]) != tolower(s[str_len - i - bias_right])) return false;`

---

# 문자열 뒤집기

[Reverse String - LeetCode](https://leetcode.com/problems/reverse-string/)

## Problem

문자 배열을 입력받아 내부적으로 직접 배열을 뒤집는 문제

### ISSUE

- 아무 값도 리턴하지 않고 곧바로 리스트를 출력한다.

## Solution

### 1. 투 포인터를 이용한 스왑

2개의 포인터를 이용해 점점 범위를 좁혀나가며 리스트 내부를 스왑한다.

### 2. 파이썬다운 방식

> 파이썬의 내장 함수를 이용하여 단 한 줄로 쉽게 풀이하는 방식을 ***‘파이썬다운 방식’*** 이라고 한다.
> 

리스트를 뒤집는 reverse() 함수를 사용하면 쉽게 구현할 수 있다.

*만약 리스트가 아닌 문자열로 주어진다면, `s = s[::-1]` 로 슬라이싱을 이용할 수도 있다. 리트코드와 같이 공간 복잡도를 제한한 문제라면 위 코드에서는 오류가 발생하므로, `s[:] = s[::-1]` 로 써주는 것이 더 안전하다 .

---

# 로그 파일 재정렬

[Reorder Data in Log Files - LeetCode](https://leetcode.com/problems/reorder-data-in-log-files/)

## Problem

문자 배열로 구성된 로그를 재정렬하는 문제

### ISSUE

- 문자로 구성된 로그의 우선순위가 숫자로 구성된 로그보다 높다. ⇒ 문자가 숫자보다 앞쪽에 위치
    - 문자와 숫자 로그파일을 분리하여 다룬다.
- 로그의 앞부분은 식별자로, 문자가 동일한 경우 식별자 순으로 정렬한다.
    - 문자 정렬 시 다중 조건으로 처리한다.
- 숫자 로그는 입력 순서대로 한다.
- 문자열 배열에서 원소인 로그는  “식별자 숫자/문자 숫자/문자”의 형식으로 공백으로 구분되어 있다.
    - 문자열을 split(” “)으로 나누어 다룬다.

### 풀이

```python
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        word = []
        digit = []
        for i in range(0, len(logs)):
            if logs[i].split(' ')[1].isdigit():
                digit.append(logs[i])
            else:
                word.append(logs[i])

        word.sort(key=lambda x : (x.split(' ')[1:], x.split(' ')[0]))
        log_result = word + digit

        return log_result
```

```python
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        word, digit = [], []
        for log in logs:
            if log.split(' ')[1].isdigit():
                digit.append(log)
            else:
                word.append(log)

        word.sort(key=lambda x: (x.split(' ')[1:], x.split(' ')[0]))
        return word + digit
```

앞으로 개선해야 할 태도

- 변수, 리스트 등 선언 시 여러 개 한번에 , 으로 초기화 및 선언 가능
- for문 사용 시, range()로 인덱스 접근이 아닌 바로 반복인자로 접근하는 것이 가독성 면에서도 좋음
- 리턴 시 굳이 새로운 빈 배열을 만들 필요 없이 바로 두 배열을 이어붙이기 해서 리턴하면 됨

## Solution

### 1. 람다와 + 연산자를 이용

문자와 숫자를 구분하고, 숫자는 그대로 이어붙인다. 문자 로그에 대해서는 식별자를 제외한 문자로 정렬하고, 같은 문자인 경우 식별자를 기준으로 정렬해야 하므로 다중 조건의 정렬을 해야 한다. 

- **파이썬 정렬 정리**
    - sorted()
        
        ```python
        sorted( <list> , key = <function> , reverse = <bool>)
        # <list> 뿐 아니라, <Tuple>, <Dictionary>, <Str>에도 사용 가능하다.
        ```
        
        원본 내용을 바꾸지 않고, 정렬한 값을 반환한다. 
        
        - `<list>, <tuple>, <dictionary>, <str>` 모두 사용 가능하다.
        - `key`를 통해 정렬 기준을 정할 수 있다.
        - `reverse` 가 True 이면 내림차순, False 이면 오름차순으로 정렬된다.
        
    - sort()
        
        ```python
        <list>.sort(key = <function>, reverse = <bool>)
        ```
        
        원본 자체를 수정하고, 반환값은 None이다. 
        
        - 원본을 수정할 수 있으므로, 불변 자료형인 튜플, 딕셔너리, 문자열에는 사용할 수 없다.
        - key 값을 통해 정렬 기준을 정할 수 있다.
        
    
    > **lambda 를 이용해 내림차순/오름차순 외에 특정 Key를 기준으로 정렬하거나, 이중 리스트 정렬, 다중 조건 정렬을 구현할 수 있다.**
    > 
    
    *lambda란? 파이썬에서의 익명 함수 → 여러 줄에 걸쳐서 작성해야 하는 함수 의 선언을 하나의 식으로 단순하게 표현할 수 있다.  리스트 대신 사용하는 리스트 컴프리헨션과 유사한 기능이다. 
    
    **`lamda [arguments] : [return 되는 expression 부분]`** 로 쓰이며 주로 sort 함수의 key= 뒤에 들어가 정렬기준을 지정할 때 유용하게 쓰인다. 
    
    참고 - [https://infinitt.tistory.com/122](https://infinitt.tistory.com/122)
    

---

# 가장 흔한 단어

[Most Common Word - LeetCode](https://leetcode.com/problems/most-common-word/)

## Problem

금지된 단어를 제외한 가장 흔하게 등장하는 단어를 출력하라. 대소문자 구분을 하지 않으며, 구두점(마침표, 쉼표 등) 또한 무시한다. 

### ISSUE

- 문자열에서 공백을 기준으로 단어를 나누고, 가장 빈도가 높은 단어를 고른다.
- 금지된 문자인지 추가적으로 검사하는 코드도 필요
    - 금지된 문자는 여러 개일 수 있음(리스트로 넘어온다)
- 대소문자 구분 X → lower()로 전체 소문자로 변경
- 각 단어와 등장한 개수를 key와 value의 한 쌍으로 저장한다. ⇒ 즉 딕셔너리 자료형을 사용

## Solution

### 1. 리스트 컴프리헨션, Counter 객체 사용

> **데이터 클렌징(Data Cleansing)** : 입력값에 대한 전처리 작업
> 

→ 정규식을 섞어 쓰면 편리하게 처리할 수 있다. 

`re.sub(r'[^\w]', ' ', paragraph)` 

- `^` : not
- `\w` : 단어 문자

딕셔너리에 기본값을 자동 부여해주는 defaultdict() 를 사용해 키 존재 유무를 확인할 필요 없이(*KeyError*가 발생하지 않으므로) 바로 counts[word] += 1로 접근이 가능하다. 

개수를 처리하는 부분은 Counter 모듈을 사용하여  most_common()에 넘겨주는 정수 번째 최다빈도 요소를 가져올 수 있다.