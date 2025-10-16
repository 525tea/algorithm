# 문자열


## String 

> 주요 메서드, 문자열과 다른 자료형 간의 변환


### 주요 메서드

1. `.valueOf(num)`

String 클래스, 숫자 num(long, int double 모두 가능)을 String으로 변환

2. `.indexOf(String str)` `.indexOf(Char ch)`

처음 등장하는 위치(int) 반환

3. `.split(String regex)`

문자열 분할, String[] 반환

ex. "java".split("") → ["j", "a", "v", "a"]

4. `trim()`

앞뒤의 공백을 제거, String 반환

ex. " java ".trim() → "java"


## StringBuilder

StringBuilder는 수정 가능한 문자열 버퍼 클래스

1. `new StringBuilder(str)`

String str을 가변 버퍼로 감쌈.


2. `.reverse()`

StringBuilder 클래스의 내장 메서드, 문자열을 뒤집고 반환


3. `.toString()`

가변 문자열 StringBuilder sb를 불변 문자열 String으로 변환
